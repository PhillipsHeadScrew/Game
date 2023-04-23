package game.Entity.Enemy;

public class Slime extends Enemy {
    public Slime(int level) {
        this.health = 2;
        this.maxHealth = 3;
        this.attack = 3;
        this.defence = 4;
        this.level = level;
        this.mana = 10;
        this.maxMana = 10;
        this.image[5] = "              __–––––__               ";
        this.image[6] = "             /  0   0  \\              ";
        this.image[7] = "            |           |             ";
        this.image[8] = "             \\_________/              ";

        int[] levelingHelper = levelingUp();

        this.health = levelingHelper[0];
        this.maxHealth = levelingHelper[1];
        this.attack = levelingHelper[2];
        this.defence = levelingHelper[3];
        this.mana = levelingHelper[4];
        this.maxMana = levelingHelper[5];
    }
}
