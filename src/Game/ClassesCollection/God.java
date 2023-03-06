package Game.ClassesCollection;

import Game.Actions;

public class God extends Character{

    private int health, attack, magic, mana, dexterity, defense;
    private String name;

    public God(String name, Actions action) {
        this.health = 1000;
        attack = 100;
        magic = 100;
        mana = 100;
        dexterity = 100;
        defense = 1000;

        this.name = name;


    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public String getName() {
        return name;
    }
}
