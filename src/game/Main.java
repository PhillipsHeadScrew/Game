package game;

import game.Entity.Player;
import game.Item.Consumables.Food.Food;
import game.Item.Consumables.Potion.Potion;
import game.Item.Empty;
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
        Empty emptySlot = new Empty();
        int showItem = 0;
        String itemUse = "";


        while (running) { // turns location into an int
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
            // makes the game screen object
            System.out.println(equal); // printing the top of the screen
            for (int i = 0; i < 18; i++) { // prints the content of the screen
                System.out.println(" |" + game_screen[j][i] + "|");
            }
            System.out.println(equal); // printing bottom of screen

            Scanner in = new Scanner(System.in); // makes a scanner
            String playerInput = in.next().toLowerCase() + in.nextLine().toLowerCase() + in.nextLine().toLowerCase(); // uses scanner

            switch (location) { // changes what the player can do based on location
                case "no_mans_land" -> { // no_mans_land is a testing area
                    previousLocation = location; // makes a copy of where the player was as not to get lost
                    switch (playerInput) { // reacts to what the player does
                        case "menu" -> location = "menu"; // takes you to the menu
                        case "close game" -> running = false; // turns the game off
                        case "get" -> { // lets the player acquire items through admin commands
                            playerInput = in.next().toLowerCase() + in.nextLine();
                            switch (playerInput) { // player gets minor healing spell or medium healing spell
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
                case "menu" -> { // player can enter into submenus or exits
                    switch (playerInput) {
                        case "back" -> location = previousLocation;
                        case "pocket", "items", "item" -> location = "items";
                        case "stats", "yourself", "stat" -> location = "stats";
                        case "notebook" -> location = "notebook";
                        case "spells" -> location = "spells";
                    }
                }
                case "stats" -> { // player can look at stats and leave
                    switch (playerInput) {
                        case "back", "leave" -> location = "menu";
                    }
                }
                case "items" -> { // player can look at the items they have and use one if they want
                    switch (playerInput) {
                        case "item", "items", "pocket" -> {}
                        default -> {
                            for (int i = 0; i < 12; i++) {
                                Item item = player.itemList.get(i);

                                for (int h = 0; h < item.nameList.size(); h ++) {
                                    if (item.nameList.get(h).equals(playerInput)) {
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
                    }
                    switch (playerInput) {
                        case "back", "away" -> location = "menu";
                        case "item" -> {

                            location = "use menu";
                        }
                    }
                }
                case "notebook" -> { // the player can in the future get hints from this place
                    switch (playerInput) {
                        case "back", "see ya" -> location = "menu";
                    }
                }
                case "spells" -> { // player can use some spells in the future
                    switch (playerInput) {
                        case "back", "bye" -> location = "menu";
                    }
                }
                case "use menu" -> { // the player has the option to use the item they chose or go back
                    switch (playerInput) {
                        case "use" -> {
                            System.out.println("food test 1");
                            switch (itemUse) {
                                case "food" -> {
                                    System.out.println("food test 2");
                                    Food itemBeingUsed = (Food) player.itemList.get(showItem);
                                    player.health = itemBeingUsed.EatingFood(itemBeingUsed.restorativePowers,
                                            player.maxHealth, player.health);
                                }
                                case "potion" -> {
                                    System.out.println("food test 2");
                                    Potion itemBeingUsed = (Potion) player.itemList.get(showItem);
                                }
                            }
                            player.itemList.set(showItem, emptySlot);
                            location = "items";
                        }
                        case "back" -> location = "items";
                    }
                }
            }
        }
    }
}
