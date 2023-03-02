package Game.ClassesCollection;

public abstract class Character {


    public abstract int getAttack();
    public abstract int getDefense();
    public abstract int getHealth();
    public abstract String getName();

    @Override
    public String toString() {
        return "Name " + getName() + " Attack: " + getAttack() + ", Defense: " + getDefense() + ", Health: " + getHealth() + ".";
    }
}
