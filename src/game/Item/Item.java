package game.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {
    public ItemsType type;
    public ItemsCategory category;

    public String name = "itemname     ";
    public List<String> nameList = new ArrayList<>();

    public String emptyDefinition = "                                      ";

    public String[] descriptionList = {emptyDefinition, emptyDefinition, emptyDefinition, emptyDefinition,
            emptyDefinition, emptyDefinition, emptyDefinition, emptyDefinition, emptyDefinition, emptyDefinition};


}
