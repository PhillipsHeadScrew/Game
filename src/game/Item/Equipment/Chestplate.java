package game.Item.Equipment;

import game.Item.ItemsType;

public class Chestplate extends Equipment {
    int power;

    Chestplate(int power, int effect, String effect_type){
        this.type = ItemsType.CHESTPLATE;
        this.power = power;
        this.effect = effect;
        this.effect_type = effect_type;
    }
}
