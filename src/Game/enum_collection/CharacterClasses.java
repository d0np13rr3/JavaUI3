package Game.enum_collection;

public enum CharacterClasses {

    HUMAN("Human"),
    ELF("Elf"),
    DWARF("Dwarf"),
    ORC("Orc"),
    GOBLIN("Goblin"),
    TROLL("Troll"),
    UNDEAD("Undead"),
    DEMON("Demon"),
    ANGEL("Angel"),
    DRAGON("Dragon"),
    GOD("God"),
    SUPERHUMAN("Superhuman");
    private String name;
    CharacterClasses(String classCharacter){
        this.name = classCharacter;
    }

    public String getName() {
        return name;
    }
}
