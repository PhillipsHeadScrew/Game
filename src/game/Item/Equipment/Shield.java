package game.Item.Equipment;

import game.Item.ItemsType;

public class Shield extends Equipment {
    int power;

    Shield(int power, int effect, String effect_type){
        this.type = ItemsType.SHIELD;
        this.power = power;
        this.effect = effect;
        this.effect_type = effect_type;
    }
}
