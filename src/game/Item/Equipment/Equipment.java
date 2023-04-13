package game.Item.Equipment;

import game.Item.Item;
import game.Item.ItemsCategory;

public class Equipment extends Item {

    public int effect = 0;
    public String effect_type;

    public Equipment () {
        this.category = ItemsCategory.EQUIPMENT;
        this.descriptionList = setEmptyDescriptionList(descriptionList);
    }
}
