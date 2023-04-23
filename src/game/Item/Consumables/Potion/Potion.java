package game.Item.Consumables.Potion;

import game.Item.Consumables.Consumables;
import game.Item.ItemsType;

public class Potion extends Consumables {

    public int restorativePowers;
    public String potionType;

    Potion() {
        this.type = ItemsType.POTIONS;
    }

    public static class Blue extends Potion {
        Blue() {
            this.potionType = "blue";
        }
        public int[] DrinkBluePotion(int health, int maxMana, int mana) {
            mana += restorativePowers;
            if (mana > maxMana) {
                int mathHelper = mana - maxMana;
                health -= mathHelper;
            }

            return new int[]{health, mana};
        }
    }

    public static class Red extends Potion {
        Red() {
            this.potionType = "red";
        }
        public int DrinkRedPotion(int health, int maxHealth) {
            health += restorativePowers;
            if (health > maxHealth) {
                int mathHelper = health - maxHealth;
                health -= mathHelper;
            }

            return health;
        }
    }
}

