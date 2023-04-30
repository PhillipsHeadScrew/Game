package game.Spells.HealingSpells;

public class MinorHealing extends HealingSpell {

    public MinorHealing() {
        this.restorativePower = 10;
        this.name = " MinorHealing      ";
        this.manaCost = 5;
        this.nameList.add("minorhealing");
        this.nameList.add("minorheal");
        this.nameList.add("minor healing");
        this.nameList.add("minor heal");
        this.nameList.add("smallheal");
        this.nameList.add("small heal");
    }
}
