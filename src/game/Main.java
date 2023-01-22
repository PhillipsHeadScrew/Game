package game;

public class Main {

    public static void main(String[] args) {
        boolean running = true;
        String equal = "==========================================";
        String location = "no_mans_land";
        int j = 0;
        Screen screen = new Screen();

        String[][] game_screen = screen.createScreen();

        while (running) {
            switch (location) {
                case "no_mans_land" -> j = 0;
            }
            System.out.println(equal);
            for (int i = 0; i < 18; i++) {
                System.out.println(" |" + game_screen[j][i] + "|");
            }
            System.out.println(equal);
        }
    }
}
