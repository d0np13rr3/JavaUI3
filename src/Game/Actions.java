package Game;

import java.util.Random;

import static Game.Main.*;

public class Actions {



    public static int determineAttack(int humanAttackLevel) {
        Random random = new Random();
        int randomInteger = random.nextInt(100);
        int attackHuman = humanAttackLevel + (randomInteger / 10);
        //console.append(humanNameOne + " attacked for " + attackHuman + "\n");
        return attackHuman;

    }    ;

    public static int determineDefense(int humanDefenseLevel) {
        Random random = new Random();
        int randomInteger = random.nextInt(100);
        int defenseHuman = (humanDefenseLevel + randomInteger / 10);
        //console.append(humanNameTwo + " blocked for " + defenseHuman + "\n");
        return defenseHuman;

    }

    public static String Battle(int humanAttackOne, int humanDefenseOne, int humanAttackTwo,  int humanDefenseTwo, int humanHealthOne, int humanHealthTwo, String humanNameOne, String humanNameTwo) {
        int playerOneLife = humanHealthOne;
        int playerTwoLife = humanHealthTwo;
        System.out.println(playerOneLife);
        System.out.println(playerTwoLife);

        // define starting player
        Random random00 = new Random();
        int randomOneOrTwo = random00.nextInt(1,3);
        // console.append(String.valueOf(randomOneOrTwo));

        while (playerOneLife >= 0 && playerTwoLife >= 0 ) {
            int AttackByOne;
            AttackByOne = determineAttack(humanAttackOne) -determineDefense(humanDefenseTwo) ;
            if (AttackByOne <=0){
                AttackByOne = 0;
            }
            playerTwoLife = playerTwoLife - AttackByOne;
            if (playerTwoLife <= 0){
                console.append(humanNameOne + " attacked for " + AttackByOne + ". " + "\n" + humanNameTwo + " lost the battle.");
                break;
            }else {
                console.append(humanNameOne + " attacked for " + AttackByOne + ". " + humanNameTwo + " has " + playerTwoLife + " health left." + "\n");
            }

            int AttackByTwo;
            AttackByTwo = determineAttack(humanAttackTwo) - determineDefense(humanDefenseOne);
            if (AttackByTwo <=0){
                AttackByTwo = 0;
            }
            playerOneLife = playerOneLife - AttackByTwo;
            if (playerOneLife <= 0){
                console.append(humanNameTwo + " attacked for " + AttackByTwo + ". " + "\n" + humanNameOne + " lost the battle.");
                break;

            }else {
                console.append(humanNameTwo + " attacked for " + AttackByTwo + ". " + humanNameOne + " has " + playerOneLife + " health left." + "\n");
            }
        }

        return "Battled";

    }
}
