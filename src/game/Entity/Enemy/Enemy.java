package game.Entity.Enemy;

import game.Entity.Entity;

import java.util.Random;

public class Enemy extends Entity {

    public int[] levelingUp() {
        int[] leveledStats = {maxHealth, attack, defence, maxMana};
        Random r = new Random();
        for (int i = 0; i < level; i++) {
            int h = r.nextInt(4);
            int j = r.nextInt(4);
            int k = r.nextInt(4);
            leveledStats[h] += 1;
            leveledStats[j] += 1;
            leveledStats[k] += 2;
        }
        this.health = leveledStats[0];
        this.mana = leveledStats[2];
        return new int[]{health, leveledStats[0], leveledStats[1], leveledStats[2], mana, leveledStats[3]};
    }
}
