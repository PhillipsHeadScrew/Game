package game;

import game.Entity.Player;
import game.Item.Consumables.Food.Food;
import game.Item.Item;
import game.Spells.HealingSpells.MediumHealing;
import game.Spells.HealingSpells.MinorHealing;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        boolean running = true;
        String equal = "==========================================";
        String location = "items";
        int j = 2;
        String previousLocation = "no_mans_land";
        Screen screen = new Screen();
        Player player = new Player();
        int showItem = 0;
        String itemUse = "";


        while (running) {
            switch (location) {
                case "no_mans_land" -> j = 0;
                case "menu" -> j = 1;
                case "items" -> j = 2;
                case "stats" -> j = 3;
                case "notebook" -> j = 4;
                case "spells" -> j = 5;
                case "use menu" -> j = 6;
            }

            String[][] game_screen = screen.createScreen(j, player, player.playerStatus, player.playerCurse);

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
                        case "get" -> {
                            playerInput = in.next().toLowerCase() + in.nextLine();
                            switch (playerInput) {
                                case "minor_healing_spell" -> {
                                    MinorHealing minorHealing = new MinorHealing();
                                    player.spellList.set(0, minorHealing);
                                    System.out.println("spell gotten");
                                }
                                case "medium_healing_spell" -> {
                                    MediumHealing mediumHealing = new MediumHealing();
                                    player.spellList.set(1, mediumHealing);
                                    System.out.println("spell gotten");
                                }
                            }
                        }
                    }
                }
                case "menu" -> {
                    switch (playerInput) {
                        case "back" -> location = previousLocation;
                        case "pocket", "items", "item" -> location = "items";
                        case "stats" -> location = "stats";
                        case "notebook" -> location = "notebook";
                        case "spells" -> location = "spells";
                    }
                }
                case "stats" -> {
                    switch (playerInput) {
                        case "back", "leave" -> location = "menu";
                    }
                }
                case "items" -> {
                    switch (playerInput) {
                        case "item", "items", "pocket" -> {}
                        default -> {
                            for (int i = 0; i < 12; i++) {

                                Item item = player.itemList.get(i);

                                if (item.name.equals(playerInput)) {
                                    location = "use menu";
                                    showItem = i;
                                    switch (item.category) {
                                        case CONSUMABLE -> {
                                            switch (item.type) {
                                                case FOOD -> itemUse = "food";
                                                case POTIONS -> itemUse = "potions";
                                                case RUNES -> itemUse = "runes";
                                            }
                                        }
                                        case EQUIPMENT -> {
                                            switch (item.type) {
                                                case HELMET -> itemUse = "helmet";
                                                case CHESTPLATE -> itemUse = "chestplate";
                                                case WEAPON -> itemUse = "weapon";
                                                case SHIELD -> itemUse = "shield";
                                                case GREAVES -> itemUse = "greaves";
                                                case BOOTS -> itemUse = "boots";
                                            }
                                        }
                                        case KEY_ITEMS -> {
                                            switch (item.type) {
                                                case KEYS -> itemUse = "keys";
                                                case TOOLS -> itemUse = "tools";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    switch (playerInput) {
                        case "back", "away" -> location = "menu";
                        case "item" -> {

                            location = "use menu";
                        }
                    }
                }
                case "notebook" -> {
                    switch (playerInput) {
                        case "back", "see ya" -> location = "menu";
                    }
                }
                case "spells" -> {
                    switch (playerInput) {
                        case "back", "bye" -> location = "menu";
                    }
                }
                case "use menu" -> {
                    switch (playerInput) {
                        case "use" -> {
                            switch (itemUse) {
                                case "food" -> {
                                    Food itemBeingUsed = (Food) player.itemList.get(showItem);
                                    player.health = itemBeingUsed.EatingFood(itemBeingUsed.restorativePowers,
                                            player.maxHealth, player.health);
                                }
                            }
                        }
                        case "back" -> location = "item";
                    }
                }
            }
        }
    }
}
