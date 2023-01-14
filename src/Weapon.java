public class Weapon extends Equipment {
    int power;

    Weapon(int power){
        this.type = ItemsType.WEAPON;
        this.power = power;
    }
}
