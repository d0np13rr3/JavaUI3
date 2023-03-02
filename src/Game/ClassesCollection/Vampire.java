package Game.ClassesCollection;

import Game.Actions;


public class Vampire extends Character{
    private int health, attack, magic, mana, dexterity, defense;
    private String name;
    Actions action = new Actions();
    public Vampire(String name, Actions action){
        health = 100;
        attack = 25;
        magic = 25;
        mana = 25;
        dexterity = 50;
        defense = 25;

        this.name = name;
    }
    public void setHealth(int healthToSet){
        this.health = healthToSet;
    }
    public void setAttack(int attackToSet){
        this.attack = attackToSet;
    }
    public int getAttack(){
        return this.attack;
    }
    public String getName() {return name;}
    public int getHealth() {return health;}
    public int getMagic() {return magic;}
    public int getMana() {return mana;}
    public int getDexterity() {return dexterity;}
    public int getDefense() {return defense;}
}
