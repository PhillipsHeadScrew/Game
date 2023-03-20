package game.Entity;

import game.Item.Consumables.Food.CannedBeans;
import game.Item.Empty;
import game.Spells.CustomSpells.EmptySpellSlot;

public class Player extends Entity {

    public status playerStatus = status.NORMAL;
    public curse playerCurse = curse.UNCURSED;



    public Player() {
        Empty emptySlot = new Empty();
        EmptySpellSlot emptySpellSlot = new EmptySpellSlot();
        CannedBeans cannedBeans = new CannedBeans();

        this.health = 6;
        this.maxHealth = 10;
        this.attack = 4;
        this.defence = 0;
        this.experience = 0;
        this.maxExperience = 10;
        this.level = 1;
        this.mana = 5;
        this.maxMana = 5;
        this.blankStat = 0;
        for (int i = 0; i < 12; i++) {
            this.itemList.add(emptySlot);
            this.spellList.add(emptySpellSlot);
        }
        this.itemList.set(0, cannedBeans);
    }
}
