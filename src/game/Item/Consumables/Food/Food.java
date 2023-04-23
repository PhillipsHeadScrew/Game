package game.Item.Consumables.Food;

import game.Item.Consumables.Consumables;
import game.Item.ItemsType;

public class Food extends Consumables {

    public int restorativePowers;

    public int EatingFood(int maxHealth, int health) {
        health += restorativePowers;
        if (health > maxHealth) {
            health = maxHealth;
        }
        return health;
    }

    Food() {
        this.type = ItemsType.FOOD;
    }
}
