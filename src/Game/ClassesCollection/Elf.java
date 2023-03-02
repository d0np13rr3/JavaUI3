package Game.ClassesCollection;

import Game.Actions;


public class Elf extends Character{
    private int health, attack, magic, mana, dexterity, defense;
    private String name;
    Actions action = new Actions();
    public Elf(String name, Actions action){
        health = 250;
        attack = 25;
        magic = 0;
        mana = 0;
        dexterity = 50;
        defense = 10;

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
