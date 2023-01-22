package game.Item.Equipment;

import game.Item.ItemsType;

public class Boots extends Equipment {
    int power;

    Boots(int power, int effect, String effect_type) {
        this.type = ItemsType.BOOTS;
        this.power = power;
        this.effect = effect;
        this.effect_type = effect_type;
    }
}
