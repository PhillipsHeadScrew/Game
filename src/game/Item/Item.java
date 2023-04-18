package game.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {
    public ItemsType type;
    public ItemsCategory category;

    public String name = "itemname     ";
    public List<String> nameList = new ArrayList<>();

    public List<String> descriptionList = new ArrayList<>();

    public String emptyDefinition = "                                      ";

    public List<String> setEmptyDescriptionList(List<String> descriptionList) {
        for (int i = 0; i < 10; i ++) {
            descriptionList.add(i, emptyDefinition);
        }
        return descriptionList;
    }

}
