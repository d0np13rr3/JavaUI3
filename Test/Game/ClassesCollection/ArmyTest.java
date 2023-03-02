package Game.ClassesCollection;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static sun.nio.cs.Surrogate.is;

import Game.ClassesCollection.Character;
import Game.ClassesCollection.Human;
import Game.ClassesCollection.God;
import Game.Actions;

class ArmyTest {
    @Test
    void getAttackOfArmy() {
        Actions action = new Actions();
        Human warrior01 = new Human("John", action);
        God god01 = new God("Thor", action);
        Character[] character = {warrior01, god01};
        Army army = new Army(character);
        assertEquals(army.getAttackOfArmy(), 110);
    }
    @Test
    void getDefenseOfArmy() {
        Actions action = new Actions();
        Human warrior001 = new Human("John", action);
        God god001 = new God("Thor", action);
        Character[] character = {warrior001, god001};
        Army army = new Army(character);
        assertEquals(1010, army.getDefenseOfArmy());
    }
    @Test
    void determineAttackbyArmy(){
        //GIVEN
        Actions action = new Actions();
        Human warrior01 = new Human("John", action);
        God god01 = new God("Thor", action);
        God god02 = new God("Thor", action);
        Character[] character = {warrior01, god01, god02};
        Army army = new Army(character);
        int attackOfArmy = army.getAttackOfArmy();

        Human warrior02 = new Human("John", action);
        Human warrior03 = new Human("Jef", action);
        Character[] character02 = {warrior02, warrior03};
        Army army2 = new Army(character02);
        int defenseOfArmy = army2.getDefenseOfArmy();
        //WHEN
        int damage = attackOfArmy - defenseOfArmy;
        //THEN
        assertEquals(190, damage);


    }

    @Test
    void lowestHealthCharactersDieFirst(){
        //GIVEN
        Actions action = new Actions();
        Human warrior01 = new Human("John", action);
        God god01 = new God("Thor", action);
        God god02 = new God("Thor", action);
        Character[] character = {warrior01, god01, god02};
        Army army1 = new Army(character);

        Human warrior02 = new Human("John", action);
        Human warrior03 = new Human("Thor", action);
        Character[] characters = {warrior02, warrior03};
        Army army2 = new Army(character);
        //WHEN
        army1.attack(army2);
        //THEN
        //assertEquals(army2.getHealthOfArmy(), 890);
        assertEquals("1", String.valueOf(army1.getSizeOfArmy(army2)));



    }

}