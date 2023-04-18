package game;

import game.Entity.Entity;
import game.Entity.Player;

public class Screen {
    public String[][] createScreen(int j, Player p, Entity.status playerStatus, Entity.curse playerCurse, String[] itemDescription) {// p = player
        String space = "                                      ";//1
        String lines = "     ––––––––––        ––––––––––     ";//3
        String line = "     ––––––––––––––––––––––––––––     "; //4
        String back = "     |           Back           |     "; //5



        String x;
        String[] stringSpace = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        String[] statList = {(String.valueOf(p.health) + 1 + p.maxHealth), String.valueOf(p.attack),
                String.valueOf(p.defence), String.valueOf((p.experience + 1 + p.maxExperience)),
                (String.valueOf(p.mana) + 1 + p.maxMana), String.valueOf(p.level)};
        // 0 health, 1 attack, 2 defence, 3 exp, 4 mana, 5 level

        switch (j) { // creates the space of items that the player holds
            case 2 -> {
                for (int i = 0; i < 12; i++ ) {
                    x = stringSpace[i].repeat(17 - p.itemList.get(i).name.length());
                    stringSpace[i] = x;
                }
            }
            case 3 -> { // creates the space between stats
                for (int i = 0; i < 6; i++ ) {
                    x = stringSpace[i].repeat(7 - statList[i].length());
                    stringSpace[i] = x;
                }
            }
        }

        // this is to show the curse and status effect in the stats menu

        String writtenPlayerStatus = "error           ";
        String writtenPlayerCurse = "error           ";

        switch (playerStatus) {
            case NORMAL -> writtenPlayerStatus = "Normal   ";
            case BURNED -> writtenPlayerStatus = "Burned   ";
            case STUNNED -> writtenPlayerStatus = "Stunned  ";
            case PARALYSED -> writtenPlayerStatus = "Paralyzed";
        }
        switch (playerCurse) {
            case UNCURSED -> writtenPlayerCurse = "Uncursed        ";
            case DISABLE_MAGIC -> writtenPlayerCurse = "Disabled Magic  ";
            case DISABLE_ATTACK -> writtenPlayerCurse = "Disabled Attack ";
            case WEAKENING_MANA -> writtenPlayerCurse = "Weakened Mana   ";
            case WEAKENING_ATTACK -> writtenPlayerCurse = "Weakened Attack ";
            case WEAKENING_HEALTH -> writtenPlayerCurse = "Weakened Health ";
            case WEAKENING_DEFENCE -> writtenPlayerCurse = "Weakened Defence";
        }

        return new String[][]{
                {space, space, space, space, space, space, space, space, space, space, space, space, space, space,
                        space, space, space, space},
                //0 no_mans_land
                {space, lines, "     | Pocket |        |Yourself|     ", lines, space, lines,
                        "     |Notebook|        | Spells |     ", lines, space, lines,
                        "     |Equipped|        |KeyItems|     ", lines, space, space, line,
                        back, line, space},
                // 1 menu
                {space, " " + p.itemList.get(0).name + stringSpace[0] + "  " + p.itemList.get(1).name + stringSpace[1] +
                        " ", space, " " + p.itemList.get(2).name + stringSpace[2] + "  " + p.itemList.get(3).name +
                        stringSpace[3] + " ", space, " " + p.itemList.get(4).name + stringSpace[4] + "  " +
                        p.itemList.get(5).name + stringSpace[5] + " ", space, " " + p.itemList.get(6).name +
                        stringSpace[6] + "  " + p.itemList.get(7).name + stringSpace[7] + " ", space, " " +
                        p.itemList.get(8).name + stringSpace[8] + "  " + p.itemList.get(9).name + stringSpace[9] + " ",
                        space, " " + p.itemList.get(10).name + stringSpace[10] + "  " + p.itemList.get(11).name +
                        stringSpace[11] + " ", space, space, line, back, line, space},
                // 2 items
                {space, " Level     " + p.level + stringSpace[5] + " " + p.experience + "/" + p.maxExperience +
                        " Exp      " + stringSpace[3], space, " " + p.health + "/" + p.maxHealth + " Health    " +
                        stringSpace[0] + p.mana + "/" + p.maxMana + " ManaPoints " + stringSpace[4], space, " " +
                        p.attack + " Attack    " + stringSpace[1] + p.defence + " Defence    " + stringSpace[2], space,
                        " Status effect: " + writtenPlayerStatus + "             ", space, " Curse: " +
                        writtenPlayerCurse + "              ", space, space, space, space, line, back, line, space},
                // 3 stats
                {space, space, space, space, space, space, space, space, space, space, space, space, space, space,
                        line, back, line, space},
                // 4 notebook
                {space, p.spellList.get(0).name + p.spellList.get(1).name, space, p.spellList.get(2).name +
                        p.spellList.get(3).name, space, p.spellList.get(4).name + p.spellList.get(5).name, space,
                        p.spellList.get(6).name + p.spellList.get(7).name, space, p.spellList.get(8).name +
                        p.spellList.get(9).name, space, p.spellList.get(10).name + p.spellList.get(11).name,
                        space, space, line, back, line, space},
                // 5 spells
                {space, itemDescription[0], itemDescription[1], itemDescription[2], itemDescription[3],
                        itemDescription[4], itemDescription[5], itemDescription[6], itemDescription[7],
                        itemDescription[8], itemDescription[9], itemDescription[10], line,
                        "     |           Use            |     ", line, back, line, space},
                // 6 use menu
        };
    }
}
