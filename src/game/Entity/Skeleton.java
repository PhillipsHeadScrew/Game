package game.Entity;

import game.Entity.Entity;

public class Skeleton extends Entity {
    Skeleton (){
        this.health = 5;
        this.maxHealth = 5;
        this.attack = 3;
        this.defence = 2;
        this.experience = 0;
        this.level = 0;
        this.mana = 4;
        this.maxMana = 4;
    }
}
