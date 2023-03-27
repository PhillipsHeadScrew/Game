package game.Item.Consumables.Potion;

import game.Item.Consumables.Consumables;
import game.Item.ItemsType;

import java.util.ArrayList;

public class Potion extends Consumables {

    public int restorativePowers;

    public ArrayList<Integer> DrinkingPotion(int restorativePowers, int maxStat, int stat, int health, String
            healthAndManaIdentifier) {
        ArrayList<Integer> returnHelper = new ArrayList<>();
        stat += restorativePowers;
        if (stat > maxStat) {
            int mathHelper = stat;
            stat = maxStat;
            health -= maxStat - mathHelper;

            returnHelper.set(0, health);

            if ("mana".equals(healthAndManaIdentifier)) {
                returnHelper.set(1, stat);
            }
        }
            return (returnHelper);
    }

    Potion() {
        this.type = ItemsType.POTIONS;
    }
}
