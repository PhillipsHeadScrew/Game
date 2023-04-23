package game.Entity.Enemy;

public class Skeleton extends Enemy {
    public Skeleton (int level){
        this.health = 5;
        this.maxHealth = 5;
        this.attack = 3;
        this.defence = 2;
        this.level = level;
        this.mana = 4;
        this.maxMana = 4;
        this.image[0] = "                 ____                 ";
        this.image[1] = "                / o o\\                ";
        this.image[2] = "                 \\  /                 ";
        this.image[3] = "                /|––|\\                ";
        this.image[4] = "               / | || \\               ";
        this.image[5] = "              0  |__|  0              ";
        this.image[6] = "                 |  |                 ";
        this.image[7] = "                 |  |                 ";
        this.image[8] = "              __/    \\__              ";

        int[] levelingHelper = levelingUp();

        this.health = levelingHelper[0];
        this.maxHealth = levelingHelper[1];
        this.attack = levelingHelper[2];
        this.defence = levelingHelper[3];
        this.mana = levelingHelper[4];
        this.maxMana = levelingHelper[5];
    }
}
