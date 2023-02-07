package game.Entity;

import game.Item.Equipment.Equipment;
import game.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Entity {

    public int health;
    public int maxHealth;
    public int level;
    public int experience;
    public int defence;
    public int attack;
    public int mana;
    public int maxMana;
    public List<Item> itemList = new ArrayList<>();
    public List<Equipment> equippedList = new ArrayList<>();

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
