package game.Item.Consumables.Food;

public class CannedBeans extends Food {
    public CannedBeans() {
        this.restorativePowers = 20;
        this.name = "CannedBeans";
        this.nameList.add("cannedbeans");
        this.nameList.add("canned beans");
        this.nameList.add("beans");
        this.descriptionList[0] = "This is a can of Heinz beanz tm. These";
        this.descriptionList[1] = "beans will restore 20 of your health. ";
        this.descriptionList[2] = "Some don't know anything about beans. ";
        this.descriptionList[3] = "Most don't know what a legume or a    ";
        this.descriptionList[4] = "pulse is.                             ";
        this.descriptionList[5] = "Pulse: A pulse is the edible seed from";
        this.descriptionList[6] = "a legume. This includes beans, peas,  ";
        this.descriptionList[7] = "lentils and chickpeas.                ";
        this.descriptionList[8] = "Legume: A legume is any plant or part ";
        this.descriptionList[9] = "of a plant in the Fabaceae family.    ";

    }
}
