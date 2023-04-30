package game.Spells.SupportSpells;

import game.Spells.Spell;
import game.Spells.SpellType;

public class FortifyStat extends Spell { // this is how fortify stat works

    public FortifyStat() {
        this.type = SpellType.SUPPORT;
        this.manaCost = 20;
        this.name = " FortifyStat       ";
        this.nameList.add("fortifystat");
        this.nameList.add("fortify stat");
    }

    public int supportSpell(int playerStat) {
        playerStat += 3;

        return playerStat;
    }
}