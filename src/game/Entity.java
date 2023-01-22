package game;

import game.Item.Equipment.Equipment;
import game.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Entity {

    int health;
    int maxHealth;
    int level;
    int experience;
    int defence;
    int attack;
    int mana;
    int maxMana;
    List<Item> itemList = new ArrayList<>();
    List<Equipment> equippedList = new ArrayList<>();

    enum status {
        BURNED,
        STUNNED,
        PARALYSED,
        NORMAL

    }
    enum curse {
        WEAKENING_ATTACK,
        WEAKENING_MANA,
        WEAKENING_DEFENCE,
        WEAKENING_HEALTH,
        DISABLE_MAGIC,
        DISABLE_ATTACK,
        UNCURSED
    }

}
