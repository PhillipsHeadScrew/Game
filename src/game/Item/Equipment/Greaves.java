package game.Item.Equipment;

import game.Item.ItemsType;

public class Greaves extends Equipment {
    int power;

    Greaves(int power, int effect, String effect_type){
        this.type = ItemsType.GREAVES;
        this.power = power;
        this.effect = effect;
        this.effect_type = effect_type;
    }
}
