package game.Entity;

import game.Entity.Entity;

public class Player extends Entity {

    Player() {
        this.health = 5;
        this.maxHealth = 5;
        this.attack = 4;
        this.defence = 3;
        this.experience = 0;
        this.level = 0;
        this.mana = 5;
        this.maxMana = 5;
    }
}
