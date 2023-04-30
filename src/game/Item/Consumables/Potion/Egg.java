package game.Item.Consumables.Potion;

public class Egg extends Potion.Blue {
    Egg() {
        this.restorativePowers = 20;
        this.potionType = "blue";
        this.nameList.add("egg");
        this.descriptionList[0] = "Egg                                   ";
        this.descriptionList[1] = "Restores 20 mana                      ";
    }
}
