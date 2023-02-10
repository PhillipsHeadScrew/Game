package game;

import game.Entity.Player;

public class Screen {
    public String[][] createScreen() {
        String space = "                                      ";//1
        String lines = "     ––––––––––        ––––––––––     ";//3
        String line = "     ––––––––––––––––––––––––––––     "; //4
        String back = "     |           Back           |     "; //5

        Player player = new Player();

        String x = "";
        String[] itemLengthSpace = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "};

        for (int i = 0; i < 12; i++ ) {
            x = itemLengthSpace[i].repeat(17 - player.itemList.get(i).name.length());
            itemLengthSpace[i] = x;
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
                {space, " " + player.itemList.get(0).name + itemLengthSpace[0] + "  " + player.itemList.get(1).name +
                        itemLengthSpace[1] + " ", space, " " + player.itemList.get(2).name + itemLengthSpace[2] + "  "
                        + player.itemList.get(3).name + itemLengthSpace[3] + " ", space, " " +
                        player.itemList.get(4).name + itemLengthSpace[4] + "  " + player.itemList.get(5).name +
                        itemLengthSpace[5] + " ", space, " " + player.itemList.get(6).name + itemLengthSpace[6] + "  "
                        + player.itemList.get(7).name + itemLengthSpace[7] + " ", space, " " +
                        player.itemList.get(8).name + itemLengthSpace[8] + "  " + player.itemList.get(9).name +
                        itemLengthSpace[9] + " ", space, " " + player.itemList.get(10).name + itemLengthSpace[10] + "  "
                        + player.itemList.get(11).name + itemLengthSpace[11] + " ", space, space, line, back, line,
                        space}
                // 2 items
        };
    }
}
