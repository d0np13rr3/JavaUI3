package Game.ClassesCollection;

public abstract class Character {

    public abstract int getAttack();
    public abstract int getDefense();
    public abstract int getHealth();

    @Override
    public String toString() {
        return "Attack: " + getAttack() + ", Defense: " + getDefense() + ", Health: " + getHealth() + ".";
    }
}
