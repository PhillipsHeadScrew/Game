package game.Spells.HealingSpells;

import game.Spells.Spell;
import game.Spells.SpellType;

public class HealingSpell extends Spell {

    public int restorativePower;

    int Heal() {
        return + restorativePower;
    }

    HealingSpell() {
        this.type = SpellType.HEALING;
    }
}
