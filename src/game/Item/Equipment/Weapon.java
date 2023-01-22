package game.Item.Equipment;

import game.Item.ItemsType;

public class Weapon extends Equipment {
    int power;

    Weapon(int power, int effect, String effect_type){
        this.type = ItemsType.WEAPON;
        this.power = power;
        this.effect = effect;
        this.effect_type = effect_type;
    }
}
