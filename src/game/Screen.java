package game;

public class Screen {

    public String[][] createScreen() {
        String space = "                                      ";//1
        String lines = "     ––––––––––        ––––––––––     ";//3
        String line = "     ––––––––––––––––––––––––––––     "; //4
        String back = "     |           Back           |     "; //5

        String[][] Screen = {
                {space, space, space, space, space, space, space, space, space, space, space, space, space, space,
                        space, space, space, space},
                {space, lines, "     | Pocket |        |Yourself|     ", lines, space, lines,
                        "     |Notebook|        | Spells |     ", lines, space, lines,
                        "     | Stuffs |        |KeyItems|     ", lines, space, space, line,
                        back, line, space}
        };
        return Screen;
    }
}
