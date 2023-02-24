package Game.ClassesCollection;

import Game.Actions;

public class God extends Character{

    private int health, attack, magic, mana, dexterity, defense;
    private String name;

    public God(String name, Actions action) {
        health = 100;
        attack = 10;
        magic = 0;
        mana = 0;
        dexterity = 25;
        defense = 10;

        this.name = name;


    }
}
