package fangdjupet.game;

import fangdjupet.combat.Enemy;
import fangdjupet.combat.Hero;
import fangdjupet.combat.MeleeAttack;
import fangdjupet.contract.GameEvent;
import fangdjupet.contract.GameEventType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {
    private final MeleeAttack melee = new MeleeAttack();
    private Game game;
    private List<GameEvent> events;

    @BeforeEach
    void setUp() {
        game = new Game();
        events = new ArrayList<>();
        game.addListener(events::add);
    }

    private Hero strongHero() {
        return new Hero("Hjälten", 30, 100, 0, melee);
    }

    private Enemy weakEnemy(String name) {
        return new Enemy(name, 1, 5, 1, 0, melee);
    }

    @Test
    void noAdventureIsActiveFromStart() {
        assertFalse(game.hasActiveAdventure());
        assertFalse(game.isOver());
        assertTrue(game.getHero().isEmpty());
    }

    @Test
    void startNewAdventureSetsHeroAndEnemies() {
        game.startNewAdventure(strongHero(), List.of(weakEnemy("Råttan"), weakEnemy("Fladdermusen")));

        assertTrue(game.hasActiveAdventure());
        assertEquals(2, game.getRemainingEnemyCount());
        assertEquals("Råttan", game.getCurrentEnemy().orElseThrow().getName());
    }

    @Test
    void defeatedEnemyIsRemovedAndEventIsPublished() {
        game.startNewAdventure(strongHero(), List.of(weakEnemy("Råttan"), weakEnemy("Fladdermusen")));

        game.fightRound();

        assertEquals(1, game.getRemainingEnemyCount());
        assertEquals("Fladdermusen", game.getCurrentEnemy().orElseThrow().getName());
        assertTrue(events.stream().anyMatch(e -> e.type() == GameEventType.ENEMY_DEFEATED));
    }

    @Test
    void gameIsOverWhenAllEnemiesAreDefeated() {
        game.startNewAdventure(strongHero(), List.of(weakEnemy("Råttan")));

        game.fightRound();

        assertTrue(game.isOver());
    }

    @Test
    void fightRoundWithoutAdventureThrows() {
        assertThrows(IllegalStateException.class, () -> game.fightRound());
    }
}
