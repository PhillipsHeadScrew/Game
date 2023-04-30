package game.Entity.Enemy;

import game.Entity.Entity;

public class Enemy extends Entity {
    public int[][] levelUp = new int[10][8];

    public int maxHealth = 1;
    public int[] levelingUp() {
            while (experience >= 10 && level < 10) {
                experience -= 10;
                level += 1;
            }
        levelUp[level - 1][7] = experience;
        return levelUp[level - 1];
    }
}
