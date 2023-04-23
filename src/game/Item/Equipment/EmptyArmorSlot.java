package game.Item.Equipment;

import game.Item.ItemsType;

public class EmptyArmorSlot extends Equipment {
    public EmptyArmorSlot() {
        this.power = 0;
        this.effect = 0;
        this.effect_type = "none";
        this.name = "             ";
        this.nameList.add("             ");
        this.type = ItemsType.UNKNOWN;
    }
}
