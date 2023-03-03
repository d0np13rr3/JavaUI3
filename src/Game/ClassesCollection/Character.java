package Game.ClassesCollection;

public abstract class Character {


    public abstract int getAttack();
    public abstract int getDefense();
    public abstract int getHealth();
    public abstract String getName();

    @Override
    public String toString() {
        return "Name " + getName() + "\n" +" Attack: " + getAttack() + "\n" +", Defense: " + getDefense() + "\n" + ", Health: " + getHealth() + ".\n";
    }
}
