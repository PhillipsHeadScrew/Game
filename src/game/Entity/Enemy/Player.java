package game.Entity.Enemy;

import game.Item.Consumables.Food.CannedBeans;
import game.Item.Consumables.Potion.SmallRedPotion;
import game.Item.Empty;
import game.Item.Equipment.EmptyArmorSlot;
import game.Spells.CustomSpells.EmptySpellSlot;

public class Player extends Enemy {

    public status playerStatus = status.NORMAL;
    public curse playerCurse = curse.UNCURSED;

    public Player() {
        Empty emptySlot = new Empty();
        EmptySpellSlot emptySpellSlot = new EmptySpellSlot();
        CannedBeans cannedBeans = new CannedBeans();
        EmptyArmorSlot emptyArmorSlot = new EmptyArmorSlot();
        SmallRedPotion smallRedPotion = new SmallRedPotion();


        this.experience = 0;
        this.maxExperience = 10;
        this.level = 1;
        this.levelUp = new int[][]{{10, 10, 4, 0, 20, 20, 1, this.experience},
                {13, 13, 5, 0, this.mana, 20, 2, this.experience}, {16, 16, 6, 0, 25, 25, 3, this.experience},
                {19, 19, 7, 0, this.mana, 25, 4, this.experience}, {22, 22, 8, 0, 30, 30, 5, this.experience},
                {25, 25, 9, 0, this.mana, 30, 6, this.experience}, {28, 28, 10, 0, 40, 40, 7, this.experience},
                {31, 31, 11, 0, this.mana, 40, 8, this.experience}, {34, 34, 12, 0, 50, 50, 9, this.experience},
                {37, 37, 13, 0, this.mana, 50, 10, this.experience}};
        int[] levelingHelper = levelingUp();

        this.health = levelingHelper[0];
        this.maxHealth = levelingHelper[1];
        this.attack = levelingHelper[2];
        this.defence = levelingHelper[3];
        this.mana = levelingHelper[4];
        this.maxMana = levelingHelper[5];
        this.level = levelingHelper[6];
        this.experience = levelingHelper[7];



        for (int i = 0; i < 12; i++) {
            this.itemList.add(emptySlot);
            this.spellList.add(emptySpellSlot);
        }

        for (int i = 0; i < 7; i++) {
            this.equippedList.add(emptyArmorSlot);
        }

        this.itemList.set(0, cannedBeans);
        this.itemList.set(1, smallRedPotion);

    }
    public int[] playerLevelUp() {
        return levelingUp();
    }

}
