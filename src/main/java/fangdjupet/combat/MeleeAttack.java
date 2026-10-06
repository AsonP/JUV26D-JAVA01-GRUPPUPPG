package fangdjupet.combat;

import fangdjupet.contract.AttackStrategy;
import fangdjupet.contract.Combatant;

/**
 * Närstrid: anfall minus försvar, men alltid minst 1 i skada.
 */
public class MeleeAttack implements AttackStrategy {
    static final int MINIMUM_DAMAGE = 1;

    @Override
    public String getName() {
        return "Närstrid";
    }

    @Override
    public int calculateDamage(Combatant attacker, Combatant defender) {
        return Math.max(MINIMUM_DAMAGE, attacker.getAttack() - defender.getDefense());
    }
}
