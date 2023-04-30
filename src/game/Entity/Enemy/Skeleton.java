package game.Entity.Enemy;

public class Skeleton extends Enemy {
    public Skeleton (int level){
        this.level = level;
        this.experience = 0;
        this.levelUp = new int[][]{{3, 3, 3, 4, 10, 10, 1, this.experience}, {5, 5, 4, 4, 10, 10, 1, this.experience},
                {8, 8, 5, 5, 10, 10, 1, this.experience}, {10, 10, 7, 6, 10, 10, 1, this.experience},
                {12, 12, 9, 7, 10, 10, 1, this.experience}, {14, 14, 10, 8, 10, 10, 1, this.experience},
                {16, 16, 11, 9, 10, 10, 1, this.experience}, {18, 18, 12, 10, 10, 10, 1, this.experience},
                {20, 20, 14, 11, 10, 10, 1, this.experience}, {22, 22, 16, 13, 10, 10, 1, this.experience}};
        int[] levelingHelper = levelingUp();

        this.health = levelingHelper[0];
        this.maxHealth = levelingHelper[1];
        this.attack = levelingHelper[2];
        this.defence = levelingHelper[3];
        this.mana = levelingHelper[4];
        this.maxMana = levelingHelper[5];
        this.level = levelingHelper[6];
        this.experience = levelingHelper[7];

        this.image[0] = "                 ____                 ";
        this.image[1] = "                / o o\\                ";
        this.image[2] = "                 \\  /                 ";
        this.image[3] = "                /|––|\\                ";
        this.image[4] = "               / | || \\               ";
        this.image[5] = "              0  |__|  0              ";
        this.image[6] = "                 |  |                 ";
        this.image[7] = "                 |  |                 ";
        this.image[8] = "              __/    \\__              ";
        this.name = "Skeleton";



    }
}
