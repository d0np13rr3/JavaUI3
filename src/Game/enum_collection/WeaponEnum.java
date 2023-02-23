package Game.enum_collection;

public enum WeaponEnum {
    AXE(0,100,0,0,0,0, "Axe"),
    BOW(0, 15,0,0,85,0, "Bow"),
    SWORD(0,75,0,0,25,0, "Sword"),
    DAGGER(0,10,0,0,90,0, "Dagger"),
    STAFF(0,1,99,0,0,0, "Staff"),
    MACE(0,80,0,0,20,0, "Mace"),
    LIGHTSABER(0,100,0,0,0,0, "Lightsaber"),
    GUN(0,25,0,0,75,0, "Gun"),
    CROSSBOW(0,35,0,0,65,0, "Crossbow"),
    SPEAR(0,60,0,0,40,0, "Spear"),
    POLEARM(0,65,0,0,35,0, "Polearm"),
    SHOTGUN(0,35,0,0,65,0, "Shotgun"),
    RIFLE(0,30,0,0,70,0, "Rifle"),
    WAND(0,1,60,0,39,0, "Wand"),
    MACHINE_GUN(0,100,0,0,0,0, "Machine Gun")
    ;

    private final int health;
    private final int attack;
    private final int magic;
    private final int mana;
    private final int dexterity;
    private final int defense;
    private final String name;

    WeaponEnum(int health, int attack, int magic, int mana, int dexterity, int defense, String name) {
        this.health = health;
        this.attack = attack;
        this.magic = magic;
        this.mana = mana;
        this.dexterity = dexterity;
        this.defense = defense;
        this.name = name;
    }

    public int getHealth() {return health;}
    public int getAttack() {return attack;}
    public int getMagic() {return magic;}
    public int getMana() {return mana;}
    public int getDexterity() {return dexterity;}
    public int getDefense() {return defense;}
    public String getName() {return name;}

}