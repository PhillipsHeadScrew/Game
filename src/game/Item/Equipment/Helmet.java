package game.Item.Equipment;

import game.Item.ItemsType;

public class Helmet extends Equipment {

    int power;

    Helmet (int power, int effect, String effect_type) {
        this.type = ItemsType.HELMET;
        this.power = power;
        this.effect = effect;
        this.effect_type = effect_type;
    }
}
