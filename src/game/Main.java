package game;

import game.Entity.Player;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        boolean running = true;
        String equal = "==========================================";
        String location = "no_mans_land";
        int j = 0;
        String previousLocation = "";
        Screen screen = new Screen();
        Player player = new Player();


        String[][] game_screen = screen.createScreen();

        while (running) {
            switch (location) {
                case "no_mans_land" -> j = 0;
                case "menu" -> j = 1;
                case "items" -> j = 2;
            }
            System.out.println(equal);
            for (int i = 0; i < 18; i++) {
                System.out.println(" |" + game_screen[j][i] + "|");
            }
            System.out.println(equal);

            Scanner in = new Scanner(System.in);
            String playerInput = in.next().toLowerCase() + in.nextLine();

            switch (location) {
                case "no_mans_land" -> {
                    previousLocation = location;
                    switch (playerInput) {
                        case "menu" -> location = "menu";
                        case "close game" -> running = false;
                        case "kay" -> System.out.println(player.itemList.get(0).name);
                    }
                }
                case "menu" -> {
                    switch (playerInput) {
                        case "back" -> location = previousLocation;
                        case "pocket", "items", "item" -> location = "items";
                    }
                }
            }


        }
    }
}
