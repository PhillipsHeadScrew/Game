package game.Entity.Enemy;

public class Slime extends Enemy {
    public Slime(int level) {
        this.level = level;
        this.experience = 0;
        this.levelUp = new int[][]{{3, 3, 3, 4, 10, 10, 1, this.experience}};
        int[] levelingHelper = levelingUp();

        this.health = levelingHelper[0];
        this.maxHealth = levelingHelper[1];
        this.attack = levelingHelper[2];
        this.defence = levelingHelper[3];
        this.mana = levelingHelper[4];
        this.maxMana = levelingHelper[5];
        this.level = levelingHelper[6];
        this.experience = levelingHelper[7];
        this.expYield = 2;

        this.image[5] = "              __–––––__               ";
        this.image[6] = "             /  0   0  \\              ";
        this.image[7] = "            |           |             ";
        this.image[8] = "             \\_________/              ";
        this.name = "Slime";

    }
}
