package Game.enum_collection;

public enum Weapon {
    AXE(0,100,0,0,0,0),
    BOW(0, 100,0,0,0,0),
    SWORD(0,100,0,0,0,0),
    DAGGER(0,100,0,0,0,0),
    STAFF(0,100,0,0,0,0),
    MACE(0,100,0,0,0,0),
    LIGHTSABER(0,100,0,0,0,0),
    GUN(0,100,0,0,0,0),
    CROSSBOW(0,100,0,0,0,0),
    SPEAR(0,100,0,0,0,0),
    POLEARM(0,100,0,0,0,0),
    SHOTGUN(0,100,0,0,0,0),
    RIFLE(0,100,0,0,0,0),
    WAND(0,100,0,0,0,0),
    MACHINE_GUN(0,100,0,0,0,0);

    private final int health;
    private final int attack;
    private final int magic;
    private final int mana;
    private final int dexterity;
    private final int defense;

    Weapon(int health, int attack, int magic, int mana, int dexterity, int defense) {
        this.health = health;
        this.attack = attack;
        this.magic = magic;
        this.mana = mana;
        this.dexterity = dexterity;
        this.defense = defense;
    }
}