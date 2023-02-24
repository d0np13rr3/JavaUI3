package Game.ClassesCollection;

import Game.Actions;

public class StringToConstructorSwitch {

    public static Character constructorClass(String classOfCharacter, String nameOfCharacter){
        Actions action = new Actions();

        switch(classOfCharacter){
            case "Human":
                Human human01 = new Human(nameOfCharacter, action);
                return human01;
            case "God":
                God god01 = new God(nameOfCharacter, action);
                return god01;
            case "Demon":
                Demon demon01 = new Demon(nameOfCharacter, action);
                return demon01;
            case "Elf":
                Elf elf01 = new Elf(nameOfCharacter, action);
                return elf01;
            case "Orc":
                Orc orc01 = new Orc(nameOfCharacter, action);
                return orc01;
            case "Troll":
                Troll troll01 = new Troll(nameOfCharacter, action);
                return troll01;
            case "Vampire":
                Vampire vampire01 = new Vampire(nameOfCharacter, action);
                return vampire01;
            case "Werewolf":
                Werewolf werewolf01 = new Werewolf(nameOfCharacter, action);
                return werewolf01;
            case "Zombie":
                Zombie zombie01 = new Zombie(nameOfCharacter, action);
                return zombie01;
            default:
                return null;
        }



    }


}
