package Game;

class Weapon{
    public int getHealth() {return health;}
    public int getAttack() {return attack;}
    public int getMagic() {return magic;}
    public int getMana() {return mana;}
    public int getDexterity() {return dexterity;}
    public void setDexterity(int dexterity) {this.dexterity = dexterity;}
    public int getDefense() {return defense;}
    public void setAttack(int attack) {this.attack = attack;}
    private int health;
    private int attack;
    private int magic;
    private int mana;
    private int dexterity;
    private int defense;
    public Weapon(String weaponName){
        String name = weaponName;
    }
}