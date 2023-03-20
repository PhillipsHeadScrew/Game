package game.Spells.AttackSpells;

import game.Spells.Spell;
import game.Spells.SpellType;

public class AttackSpell extends Spell {

    protected int destructivePower;

    int Attack(int enemyHealth) {
        return - destructivePower;
    }

    AttackSpell() {
        this.type = SpellType.ATTACK;
    }
}
