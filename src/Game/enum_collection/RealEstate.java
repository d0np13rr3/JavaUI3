package Game.enum_collection;


public enum RealEstate {


    HOUSE(10000),
    APARTMENT(2000),
    MANSION(850000),
    CASTLE(7500000),
    PALACE(22000000),
    WAREHOUSE(25000),
    VILLA(100000),
    WOODEN_CABINE(100);

    int value;
    RealEstate(int value) {
        this.value = value;
    }

    public String getCost() {
        return String.valueOf(value);
    }
}

