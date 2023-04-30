package game.Spells.CustomSpells;

import game.Spells.Spell;
import game.Spells.SpellType;

public class EmptySpellSlot extends Spell {
    public EmptySpellSlot() {
        this.type = SpellType.EMPTY;
        this.name = "                   ";
    }
}
