package game;

import game.Entity.Enemy.Enemy;
import game.Entity.Enemy.Player;
import game.Entity.Enemy.Slime;
import game.Item.Consumables.Food.Food;
import game.Item.Consumables.Potion.Potion;
import game.Item.Empty;
import game.Item.Equipment.Equipment;
import game.Item.Item;
import game.Spells.AttackSpells.AttackSpell;
import game.Spells.HealingSpells.HealingSpell;
import game.Spells.HealingSpells.MediumHealing;
import game.Spells.HealingSpells.MinorHealing;
import game.Spells.Spell;
import game.Spells.SupportSpells.FortifyStat;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        boolean running = true;
        String equal = "==========================================";
        String location = "first room";
        String playerInput = "test";
        int j = 9;
        String previousLocation = "no_mans_land";
        Screen screen = new Screen();
        Player player = new Player();
        Empty emptySlot = new Empty();
        Enemy enemy = new Enemy();
        int showItem = 0;
        int showSpell;
        String itemUse = "";
        String[] descriptionOfUsedItem = {"", "", "", "", "", "", "", "", "", ""};
        for (int k = 0; k < 10; k++) {
            descriptionOfUsedItem[k] = (emptySlot.emptyDefinition);
        }
        boolean[] hasNotPlayerBeenThere = {true, true, true, true, true, true, true, true, true, true, true, true};


        while (running) { // turns location into an int
            switch (location) {
                case "no_mans_land" -> j = 0;
                case "menu" -> j = 1;
                case "items" -> j = 2;
                case "stats" -> j = 3;
                case "notebook" -> j = 4;
                case "spells" -> j = 5;
                case "use menu" -> j = 6;
                case "fight screen" -> j = 7;
                case "fight menu" -> j = 8;
                case "first room" -> j = 9;
                case "second room" -> j = 10;
                case "tutorial note" -> j = 11;
            }
            int[] levelingHelper = player.playerLevelUp();
            player.health = levelingHelper[0];
            player.maxHealth = levelingHelper[1];
            player.attack = levelingHelper[2];
            player.mana = levelingHelper[4];
            player.maxMana = levelingHelper[5];
            player.experience = levelingHelper[7];
            player.defence = 0; // this resets the defence before adding all the equipment power to player defence
            for (int i = 0; i < 7; i++) { // this adds the power of all equipment to the player defence
                player.defence += player.equippedList.get(i).power;
            }

            String[][] game_screen = screen.createScreen(j, player, descriptionOfUsedItem, showItem, enemy);
            // makes the game screen object
            System.out.println(equal); // printing the top of the screen
            for (int i = 0; i < 18; i++) { // prints the content of the screen
                System.out.println(" |" + game_screen[j][i] + "|");
            }
            System.out.println(equal); // printing bottom of screen
            Scanner in = new Scanner(System.in); // makes a scanner
            if (!hasNotPlayerBeenThere[9]) {
                playerInput = in.next().toLowerCase() + in.nextLine().toLowerCase();
            } // uses scanner

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
                                case "slime" -> {
                                    enemy = new Slime(2);
                                    location = "fight screen";
                                    previousLocation = "no_mans_land";
                                }
                                case "xp" -> player.experience += 100;
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
                        case "item", "items", "pocket", "             " -> {
                        }
                        default -> {
                            for (int i = 0; i < 12; i++) {
                                Item item = player.itemList.get(i);

                                for (int h = 0; h < item.nameList.size(); h++) {
                                    if (item.nameList.get(h).equals(playerInput)) {
                                        location = "use menu";
                                        showItem = i;
                                        descriptionOfUsedItem = player.itemList.get(showItem).descriptionList;
                                        switch (item.category) {
                                            case CONSUMABLE -> {
                                                switch (item.type) {
                                                    case FOOD -> itemUse = "food";
                                                    case POTIONS -> itemUse = "potions";
                                                    case RUNES -> itemUse = "runes";
                                                }
                                            }
                                            case EQUIPMENT -> itemUse = "equipment";

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
                        case "item" -> location = "use menu";
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
                        case "spells" -> {}
                        default -> {
                            for (int i = 0; i < 12; i++) {
                            Spell spell = player.spellList.get(i);
                                for (int h = 0; h < player.spellList.size(); h++) {
                                    if (spell.nameList.get(h).equals(playerInput)) {
                                        if (player.mana < player.spellList.get(i).manaCost) {
                                            showSpell = i;
                                            switch (spell.type) {
                                                case SUPPORT -> {
                                                    FortifyStat spellBeingUsed = (FortifyStat) player.spellList.get(i);
                                                    boolean playerChoseNot = true;
                                                    while (playerChoseNot) {
                                                        System.out.println("""
                                                            What stat do you choose to fortify?
                                                            Defence
                                                            Attack""");
                                                        String playerInput2 = in.next().toLowerCase() +
                                                                in.nextLine().toLowerCase();
                                                        switch (playerInput2) {
                                                            case "attack" -> {
                                                                spellBeingUsed.supportSpell(player.attack);
                                                                playerChoseNot = false;
                                                            }
                                                            case "defence" -> {
                                                                spellBeingUsed.supportSpell(player.defence);
                                                                playerChoseNot = false;
                                                            }
                                                            case "back" -> playerChoseNot = false;
                                                            default -> System.out.println("either you wrote it wrong " +
                                                                    "or wrote gibberish, if you are wondering how to " +
                                                                    "cancel the spell: write 'back'");
                                                        }
                                                    }
                                                }
                                                case HEALING -> {
                                                    HealingSpell spellBeingUsed = (HealingSpell)
                                                            player.spellList.get(i);
                                                    player.health = spellBeingUsed.Heal();
                                                }
                                                case ATTACK -> {
                                                    AttackSpell spellBeingUsed = (AttackSpell)
                                                            player.spellList.get(i);
                                                    enemy.health = spellBeingUsed.Attack();
                                                }
                                            }
                                            player.mana -= player.spellList.get(showSpell).manaCost;
                                        }
                                    } else  {
                                        System.out.println("You do not have enough mana for this spell");
                                    }
                                }
                            }
                        }
                    }
                }
                case "use menu" -> { // the player has the option to use the item they chose or go back
                    String useMenuButton;
                    switch (player.itemList.get(showItem).type) {
                        case FOOD -> useMenuButton = "eat";
                        case POTIONS -> useMenuButton = "drink";
                        case RUNES -> useMenuButton = "attach";
                        case BOOTS, CHESTPLATE, GREAVES, HELMET, WEAPON -> useMenuButton = "equip";
                        default -> useMenuButton = "use";
                    }
                    if (playerInput.equals(useMenuButton)) {
                        switch (itemUse) {
                            case "food" -> {
                                Food itemBeingUsed = (Food) player.itemList.get(showItem);
                                player.health = itemBeingUsed.EatingFood(player.maxHealth, player.health);
                            }
                            case "potions" -> {
                                System.out.println("food test 2");
                                switch (((Potion) player.itemList.get(showItem)).potionType) {
                                    case "red" -> {
                                        Potion.Red itemBeingUsed = (Potion.Red) player.itemList.get(showItem);
                                        player.health = itemBeingUsed.DrinkRedPotion(player.health,
                                                player.maxHealth);
                                        System.out.println(player.health);
                                    }
                                    case "blue" -> {
                                        Potion.Blue itemBeingUsed = (Potion.Blue) player.itemList.get(showItem);
                                        int[] returnHelper = itemBeingUsed.DrinkBluePotion(player.health,
                                                player.maxMana, player.mana);
                                        player.health = returnHelper[0];
                                        player.mana = returnHelper[1];
                                    }
                                }
                            }
                            case "equipment" -> {
                                Equipment itemBeingUsed = (Equipment) player.itemList.get(showItem);
                                player.equippedList = itemBeingUsed.Equip((ArrayList<Equipment>) player.equippedList,
                                        itemBeingUsed);
                            }
                        }
                        player.itemList.set(showItem, emptySlot);
                        location = "items";
                    }
                    else if (playerInput.equals("back")) {
                        location = "items";
                    }
                }
                case "fight screen" -> {
                    if (playerInput.equals("menu")) {
                        location = "fight menu";
                    }
                }
                case "fight menu" -> {
                    switch (playerInput) {
                        case "back" -> location = "fight screen";
                        case "pocket", "items", "item" -> location = "items";
                        case "stats", "yourself", "stat" -> location = "stats";
                        case "spells" -> location = "spells";
                        case "fight", "punch", "hit" -> {
                            location = "fight screen";

                            int damage = enemy.defence - player.attack;
                            if (damage < 1) {
                                damage = 1;
                            }
                            enemy.health -= damage;
                            if (enemy.health < 1) {
                                player.experience += 1;
                                location = previousLocation;
                            }

                            damage = player.defence - enemy.attack;
                            if (damage < 1) {
                                damage = 1;
                            }
                            player.health -= damage;
                            if (player.health < 1) {
                                System.out.println("you died \nlol");
                                running = false;
                            }
                        }
                    }
                }
                case "first room" -> {
                    if (hasNotPlayerBeenThere[j]) {
                        System.out.println("Hey");
                        Thread.sleep(400);
                        System.out.println("Hey you! Who are you!");
                        Thread.sleep(2000);
                        System.out.println("Why are you in my head? How do I know you are in my head?");
                        Thread.sleep(4000);
                        System.out.println("Where are we? No matter, we need to get out.");
                        Thread.sleep(3500);
                        System.out.println("I have been awake longer than you.");
                        Thread.sleep(2500);
                        System.out.println("""
                                I have searched the room and I found some clothes, a liquid in a bottle, a weapon and a
                                note in a language I can't read. But I can't leave because I'm wounded. *groan*
                                """);
                        Thread.sleep(10000);
                        System.out.println("I tried to explore, but i got hurt when fighting some kind of skeleton.\n" +
                                "At least I won.");
                        Thread.sleep(4000);
                        System.out.println("Let me show you.");
                        Thread.sleep(2000);
                        hasNotPlayerBeenThere[j] = false;
                        location = "tutorial note";
                    }
                    switch (playerInput) {
                         case "go through door" -> location = "second room";
                         case "menu" -> {
                             location = "menu";
                             previousLocation = "first room";
                         }
                    }
                }
                case "tutorial note" -> {
                    if (playerInput.equals("back")) {
                        location = "first room";
                    }
                }
            }
        }
    }
}
