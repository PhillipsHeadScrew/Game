package game.Entity;

import game.Item.Equipment.Equipment;
import game.Item.Item;
import game.Spells.Spell;

import java.util.ArrayList;
import java.util.List;

public class Entity {

    public int health;
    public int maxHealth;

    public int mana;
    public int maxMana;

    public int level;
    public int experience;
    public int maxExperience;

    public int defence;
    public int attack;

    public int blankStat;

    public List<Spell> spellList = new ArrayList<>();
    public List<Item> itemList = new ArrayList<>();
    public List<Equipment> equippedList = new ArrayList<>();

    public enum status {
        BURNED,
        STUNNED,
        PARALYSED,
        NORMAL

    }
    public enum curse {
        WEAKENING_ATTACK,
        WEAKENING_MANA,
        WEAKENING_DEFENCE,
        WEAKENING_HEALTH,
        DISABLE_MAGIC,
        DISABLE_ATTACK,
        UNCURSED
    }
}
