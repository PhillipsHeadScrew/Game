package game.Entity;

import game.Item.Consumables.Food.CannedBeans;
import game.Item.Empty;

public class Player extends Entity {

    public Player() {
        Empty emptySlot = new Empty();
        CannedBeans cannedBeans = new CannedBeans();

        this.health = 5;
        this.maxHealth = 5;
        this.attack = 4;
        this.defence = 3;
        this.experience = 0;
        this.maxExperience = 10;
        this.level = 1;
        this.mana = 5;
        this.maxMana = 5;
        for (int i = 0; i < 12; i++) {
            this.itemList.add(emptySlot);
        }
        this.itemList.set(0, cannedBeans);

    }
}
