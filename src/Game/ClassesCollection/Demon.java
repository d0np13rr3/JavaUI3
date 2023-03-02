package Game.ClassesCollection;

import Game.Actions;


public class Demon extends Character{
    private int health, attack, magic, mana, dexterity, defense;
    private String name;
    Actions action = new Actions();
    public Demon(String name, Actions action){
        health = 100;
        attack = 100;
        magic = 50;
        mana = 50;
        dexterity = 25;
        defense = 50;

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
