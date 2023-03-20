package game.Spells.SupportSpells;

import game.Spells.Spell;

public class SupportSpell extends Spell {

    protected int supportPower;

    public int[] supportSpell(int playerStat, int playerStat2, int changeAmount, String changedStat) {
        switch (changedStat) {
            case "health" -> {
                playerStat += changeAmount;
                playerStat2 += changeAmount;
            }
            case "mana" -> {
                playerStat += changeAmount;
                playerStat2 += changeAmount;
            }
            case "attack" -> playerStat += changeAmount;
            case "defence" -> playerStat += changeAmount;
        }

        return new int[]{playerStat, playerStat2, changeAmount};
    }
}