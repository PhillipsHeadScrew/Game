package game.Spells.HealingSpells;

public class MajorHealing extends HealingSpell {

    public MajorHealing() {
        this.restorativePower = 40;
        this.name = " MajorHealing      ";
        this.manaCost = 20;
        this.nameList.add("majorhealing");
        this.nameList.add("majorheal");
        this.nameList.add("major healing");
        this.nameList.add("major heal");
        this.nameList.add("bigheal");
        this.nameList.add("big heal");
    }
}
