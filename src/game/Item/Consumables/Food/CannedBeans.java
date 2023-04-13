package game.Item.Consumables.Food;

public class CannedBeans extends Food {
    public CannedBeans() {
        this.restorativePowers = 20;
        this.name = "CannedBeans";
        this.nameList.add("cannedbeans");
        this.nameList.add("canned beans");
        this.nameList.add("beans");
        this.descriptionList.set(0, "This is a can of Heinz beanz tm. These");
        this.descriptionList.set(1, "beans will restore 20 of your health. ");
        this.descriptionList.set(3, "Some don't know anything about beans. ");
        this.descriptionList.set(4, "Most don't know what a legume or a    ");
        this.descriptionList.set(5, "pulse is.                             ");
        this.descriptionList.set(6, "Pulse: A pulse is the edible seed from");
        this.descriptionList.set(7, "a legume. This includes beans, peas,  ");
        this.descriptionList.set(8, "lentils and chickpeas.                ");
        this.descriptionList.set(9, "Legume: A legume is any plant or part ");
        this.descriptionList.set(10, "of a plant in the Fabaceae family.    ");

    }
}
