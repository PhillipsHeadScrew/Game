package game.Item.Equipment;

import game.Item.Item;
import game.Item.ItemsCategory;

import java.util.ArrayList;

public class Equipment extends Item {

    public int power;

    public int effect = 0;
    public String effect_type;

    public Equipment () {
        this.category = ItemsCategory.EQUIPMENT;
    }

    public ArrayList<Equipment> Equip(ArrayList<Equipment> equipmentList, Equipment armorPiece) {
        int x = 5;

        switch (type) {
            case HELMET -> x = 0;
            case CHESTPLATE -> x = 1;
            case GREAVES -> x = 2;
            case BOOTS -> x = 3;
            case WEAPON -> x = 4;
        }
        if (x == 5) {
            System.out.println("error, x = " + x);
        }
        else {
            equipmentList.set(x, armorPiece);
        }

        return equipmentList;
    }
}
