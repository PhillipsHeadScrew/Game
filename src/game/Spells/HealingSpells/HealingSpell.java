package game.Spells.HealingSpells;

import game.Spells.Spell;
import game.Spells.SpellType;

public class HealingSpell extends Spell {

    protected int restorativePower;

    int Heal(int playerHealth) {
        return + restorativePower;
    }

    HealingSpell() {
        this.type = SpellType.HEALING;
    }
}
