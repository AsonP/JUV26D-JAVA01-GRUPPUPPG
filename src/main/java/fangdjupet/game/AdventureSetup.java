package fangdjupet.game;

import fangdjupet.combat.Enemy;
import fangdjupet.combat.Hero;
import fangdjupet.combat.MeleeAttack;

import java.util.List;

/**
 * Skapar hjälte och fiender för ett nytt äventyr.
 * Tillfällig lösning: ersätts av EnemyFactory när föremålsmodulen finns.
 */
public final class AdventureSetup {
    private static final String DEFAULT_HERO_NAME = "Hjälten";

    private AdventureSetup() {
    }

    public static Hero createHero(String name) {
        String heroName = (name == null || name.isBlank()) ? DEFAULT_HERO_NAME : name.trim();
        return new Hero(heroName, 40, 8, 3, new MeleeAttack());
    }

    public static List<Enemy> createEnemies() {
        MeleeAttack melee = new MeleeAttack();
        return List.of(
                new Enemy("Råttan", 1, 10, 4, 0, melee),
                new Enemy("Goblinen", 2, 18, 6, 2, melee),
                new Enemy("Trollet", 3, 24, 9, 4, melee)
        );
    }
}
