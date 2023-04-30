package game.Spells.HealingSpells;

public class MediumHealing extends HealingSpell {

    public MediumHealing() {
        this.restorativePower = 20;
        this.name = " MediumHealing     ";
        this.manaCost = 10;
        this.nameList.add("mediumhealing");
        this.nameList.add("mediumheal");
        this.nameList.add("medium healing");
        this.nameList.add("medium heal");
        this.nameList.add("heal");
    }
}
