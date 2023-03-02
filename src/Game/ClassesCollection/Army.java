package Game.ClassesCollection;

import Game.Actions;

import java.util.*;
import java.util.Random;

public class Army {
    Character[] character;
    private int attackOfArmy;
    private int defenseOfArmy;
    private int healthOfArmy;
    private int sizeArmy = 0;
    private int healthArmy;

    //TryMe
    HashMap<String, Character> armyToAdd = new HashMap<String, Character>();
    public HashMap<String, Character> putArmyInDict(Army army) {
        for (Character character: character){
            armyToAdd.put(character.getName(), character);
        }return armyToAdd;
    }
    //Works
    //This builds an army of characters
    public Army(Character[] character) {
        this.character = character;
    }
    //Actions on Dictionaries
    static String removeCharacterFromDictByKey(HashMap<String, Character> armyToAddOne, String keyValue) {
        String returned_value = String.valueOf(armyToAddOne.remove(keyValue));
        for(Map.Entry<String, Character> key : armyToAddOne.entrySet()) {
            //System.out.println(key.getKey() + " " + key.getValue());
        }return returned_value;
    }
    //make a list to have a value to delete
    static String removeCharacterFromDictByValue(HashMap<String, Character> armyToAddOne, String valueHealth) {
        //String returned_value = String.valueOf(armyToAddOne.remove(keyValue));
        String returned_value = "";
        for(Map.Entry<String, Character> key : armyToAddOne.entrySet()) {
            if (key.getValue().getHealth() == Integer.parseInt(valueHealth)){
                returned_value = key.getValue().getName();
                armyToAddOne.remove(returned_value);
                //returned_value = String.valueOf(key);
                break;
            }
        }
        return returned_value;
    }
    public int totalOfDictValues(ArrayList<Integer> intValues){
        int sumValues = 0;
        for(int i : intValues){
            sumValues = sumValues + i;
        }
        return sumValues;
    }
    static int getHealthFromArmy(HashMap<String, Character> armyToAddOne, Army army) {
        ArrayList<Integer> listOfKeysHealth = new ArrayList<Integer>();
        for(Map.Entry<String, Character> key : armyToAddOne.entrySet()) {
            listOfKeysHealth.add(key.getValue().getHealth());
        }
        int total = army.totalOfDictValues(listOfKeysHealth);
        return total;
    }
    static ArrayList<Integer> getHealthFromArmyUniqueSet(HashMap<String, Character> armyToAddOne, Army army) {
//        //This prodcues a list of unique values
//        Set<Integer> listOfKeysHealth = new HashSet<Integer>();
//        for(Map.Entry<String, Character> key : armyToAddOne.entrySet()) {
//            listOfKeysHealth.add(key.getValue().getHealth());
//        }
//        ArrayList<Integer> UniqueHealthToCollect = new ArrayList<Integer> (listOfKeysHealth);
//        Collections.reverse(UniqueHealthToCollect);
//        return UniqueHealthToCollect;

        ArrayList<Integer> HealthToCollect = new ArrayList<Integer>();
        for(Map.Entry<String, Character> key : armyToAddOne.entrySet()) {
            HealthToCollect.add(key.getValue().getHealth());
        }
        Collections.sort(HealthToCollect);
        //Collections.reverse(HealthToCollect);
        return HealthToCollect;
    }
    static int getDefenseFromArmy(HashMap<String, Character> armyToAddOne, Army army) {
        ArrayList<Integer> listOfKeysDefense = new ArrayList<Integer>();
        for(Map.Entry<String, Character> key : armyToAddOne.entrySet()) {
            listOfKeysDefense.add(key.getValue().getDefense());
        }
        int total = army.totalOfDictValues(listOfKeysDefense);
        return total;
    }
    int getAttackFromArmy(HashMap<String, Character> armyToAddOne, Army army) {
        ArrayList<Integer> listOfKeysAttack = new ArrayList<Integer>();
        for(Map.Entry<String, Character> key : armyToAddOne.entrySet()) {
            listOfKeysAttack.add(key.getValue().getAttack());
        }
        int total = army.totalOfDictValues(listOfKeysAttack);
        return total;
    }
    String battleBetweenArmies(HashMap<String, Character> armyOne, Army armyOneMade, HashMap<String, Character> armyTwo, Army armyTwoMade){
        Random random = new Random();
        //Determine attack of first army
        //Determine starting health of armies
        int startArmyOne = armyOneMade.getHealthFromArmy(armyOne, armyOneMade);
        int startArmyTwo = armyTwoMade.getHealthFromArmy(armyTwo, armyTwoMade);
        int DamageOneToTransfer = 0;
        int DamageTwoToTransfer = 0;
        //resultstring initalized
        String res = "";
        //while loop that battles two armies
        while( startArmyOne > 0 && startArmyTwo > 0) {
            //first army
            int attackOne = (int) (armyOneMade.getAttackFromArmy(armyOne, armyOneMade)*(random.nextDouble(0.5,1.5)));
            int defenseTwo = (int) (armyTwoMade.getDefenseFromArmy(armyTwo, armyTwoMade)*(random.nextDouble(0.5,1.5)));
            int damageDone1 = attackOne + DamageOneToTransfer - defenseTwo;
            if (damageDone1 <= 0) {
                damageDone1 = 0;
            }
            //System.out.println("/*--------------------------------------------*/");
            //System.out.println(damageDone1 + "damageDone1 before Start");
            startArmyTwo = startArmyTwo - damageDone1;
            res = res + damageDone1 + " damage done by army 1. " + startArmyTwo + " army 2 health left. " + armyTwo.size() + " size of army 2\n";
            //determine which values of health are in army two
            ArrayList<Integer> CollectedHealthFromArmyTwo = getHealthFromArmyUniqueSet(armyTwo, armyTwoMade);
            //loop over damage to remove characters starting with lowest health
            while(damageDone1 > 0){
                if(CollectedHealthFromArmyTwo.size() == 0){
                    break;
                }
                //System.out.println("/*--------------------------------------------*/");
                //System.out.println(damageDone1 + "damageDone1 Start");
                //removing characters
                for (int health: CollectedHealthFromArmyTwo){
                res = res + removeCharacterFromDictByValue(armyTwo, String.valueOf(health)) + " died. \n";
                //if at a certain moment the health is to high compared to soldier health value needs to lower that health
                damageDone1 = damageDone1 - health;
                if (damageDone1 == 0){
                    break;
                }
                //System.out.println(damageDone1 + "damageDone1 after  - health");
                if(health > damageDone1){
                    //System.out.println(health + " health in comparison");
                    //System.out.println(damageDone1 + "damageDone1 in comparison");
                    DamageOneToTransfer = damageDone1;
                    damageDone1 = 0;
                    break;
                    //System.out.println(damageDone1 + "damageDone1 after declaration");
                    //System.out.println("/*--------------------------------------------*/");
                }
                }
            }
            res = res + "armyOne attacked = " + attackOne + ", armyTwo has defense = " + defenseTwo + "\n";
            res = res + "/*--------------------------------------------*/\n";
            if(startArmyTwo <= 0){
                break;
            }

            //second army
            int defenseOne = (int) (armyOneMade.getDefenseFromArmy(armyOne, armyOneMade)*(random.nextDouble(0.75,1.25)));
            int attackTwo = (int) (armyTwoMade.getAttackFromArmy(armyTwo, armyTwoMade)*(random.nextDouble(0.75,1.25)));
            int damageDone2 = attackTwo - defenseOne;
            if (damageDone2 <= 0) {
                damageDone2 = 0;
            }
            startArmyOne = startArmyOne - damageDone2;
            res = res + damageDone2 + " damage done by army two. " + startArmyOne + " army one health." + armyOne.size() + " size of army 1\n";
            //determine which values of health are in army two
            ArrayList<Integer> CollectedHealthFromArmyOne = getHealthFromArmyUniqueSet(armyOne, armyOneMade);
            //loop over damage to remove characters starting with lowest health
            //infinite loop over this---------------------//
            while(damageDone2 > 0){
                if(CollectedHealthFromArmyOne.size() == 0){
                    break;
                }
                //System.out.println(damageDone2 + "damageDone2 Start");
                //System.out.println(CollectedHealthFromArmyOne + "CollectedHealthFromArmyOne");
                //removing characters
                for (int health: CollectedHealthFromArmyOne){
                    //System.out.println(health + "health in army one");
                    res = res + removeCharacterFromDictByValue(armyOne, String.valueOf(health)) + " died. \n";
                    //if at a certain moment the health is to high compared to soldier health value needs to lower that health
                    damageDone2 = damageDone2 + DamageTwoToTransfer - health;
                    if (damageDone2 == 0){
                        break;
                    }
                    //System.out.println(damageDone2 + "damageDone2 after  - health");
                    if(health > damageDone2){
                        //System.out.println(health + " health in comparison");
                        //System.out.println(damageDone2 + "damageDone2 in comparison");
                        DamageTwoToTransfer = damageDone2;
                        damageDone2 = 0;
                        break;
                    }
                }
            }
            res = res + "armyTwo attacked = " + attackTwo + ", armyOne  has defense = " + defenseOne + "\n";
            res = res + "/*--------------------------------------------*/\n";
            if(startArmyOne <= 0){
                break;
            }
            //System.out.println("Two vs One");
            }


            return res;
        }


    //actions on armies
    public int getAttackOfArmy() {
        for (Character character: character) {
            attackOfArmy = attackOfArmy + character.getAttack();
        }
        return attackOfArmy;
    }
    public int getHealthOfArmy() {
        for (Character character: character) {
            character.getHealth();
            healthOfArmy = healthOfArmy + character.getHealth();
        }
        return healthOfArmy;
    }
    public int getSizeOfArmy(Army army) {
        //System.out.println(army + "armySize");
        for(Character character: character){
            sizeArmy = sizeArmy +1;
            //System.out.println(character + "chararmySize");
        }
        //returns actual size of army
        return sizeArmy;
    }
    public int getDefenseOfArmy() {
        for (Character character: character) {
            defenseOfArmy = defenseOfArmy + character.getDefense();
        }
        //System.out.println(defenseOfArmy);
        return defenseOfArmy;

    }
    public int getHealthArmy() {
        for (Character character: character) {
            healthArmy = healthArmy + character.getHealth();
        }
        return healthArmy;
    }
    public void printArmy(){
        for (Character character: character){
            System.out.println(character);
        }
    }
    public void printArmyStats(){
        for (Character character: character){
            System.out.println(character.getName() + " has " + character.getHealth());
        }
    }
}

class ArmyApp{

    public static void main(String[] args) {
        //Making of characters - all before battle between armies
        Actions action = new Actions();
        Character[] character = new Character[9];
        character[0] = new Goblin("Pikachu", action);
        character[1] = new Goblin("Charmander", action);
        character[2] = new Goblin("Squirtle", action);
        character[3] = new Goblin("Pichu", action);
        character[4] = new Human("Wartortle", action);
        character[5] = new Human("Bronzor", action);
        character[6] = new Skeleton("Gardevoir", action);
        character[7] = new Skeleton("Tepig", action);
        character[8] = new Skeleton("Electrabuzz", action);
        Character[] character00 = new Character[3];
        character00[0] = new Demon("Satan",action);
        character00[1] = new Human("Mephisto",action);
        character00[2] = new Werewolf("Diablo",action);
        //First step - building army
        Army army1 = new Army(character);
        Army army2 = new Army(character00);
        //Putting army1 in HashMap
        HashMap<String, Character> armyToAddOne = army1.putArmyInDict(army1);
        for(Map.Entry<String, Character> key : armyToAddOne.entrySet()) {
            //System.out.println(key.getKey() + " " + key.getValue());
        }
        //Putting army2 in HashMap
        HashMap<String, Character> armyToAddTwo = army2.putArmyInDict(army2);
        for(Map.Entry<String, Character> key : armyToAddTwo.entrySet()) {
            //System.out.println(key.getKey() + " " + key.getValue());
        }
        //Collecting Attack
        int ArmyAttack = army1.getAttackFromArmy(armyToAddOne, army1);
        //System.out.println(ArmyAttack + " army total attack.");
        //Collecting Defense
        int ArmyDefense = army1.getDefenseFromArmy(armyToAddOne, army1);
        //System.out.println(ArmyDefense + " army total defense.");
        //Collecting Health
        int ArmyHealth = army1.getHealthFromArmy(armyToAddOne, army1);
        //System.out.println(ArmyHealth + " army total health.");
        //Removing character
        army1.removeCharacterFromDictByKey(armyToAddOne,"Squirtle");
        //Battle
        String result = army1.battleBetweenArmies(armyToAddOne, army1, armyToAddTwo, army2);
        System.out.println("Battled armies:\n\n" + result);

//        System.out.println(army1.getAttackOfArmy());
//        System.out.println(army1.getDefenseOfArmy());
//        System.out.println(army1.getHealthOfArmy());
//        System.out.println(army1.getSizeOfArmy(army1));
//        army1.printArmy();
//        army1.printArmyStats();




    }




}
