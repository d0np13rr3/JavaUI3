package Game;

import java.util.ArrayList;
import java.util.Random;

import static Game.Main.*;

import Game.import_export_data.*;

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
        ArrayList<String> Battlelog = new ArrayList<String>();
        //Battlelog.add("Health: 1 - " + humanHealthOne + " Health: 2 - " + humanHealthTwo);
        int playerOneLife = humanHealthOne;
        int playerTwoLife = humanHealthTwo;
        //Battlelog.add("Player One Life " + playerOneLife);
        //Battlelog.add("Player Two Life " + playerTwoLife);

        // define starting player
        Random random00 = new Random();
        int randomOneOrTwo = random00.nextInt(1,3);
        // console.append(String.valueOf(randomOneOrTwo));

        while (playerOneLife >= 0 && playerTwoLife >= 0 ) {
            console.setText("");
            int AttackByOne;
            AttackByOne = determineAttack(humanAttackOne) -determineDefense(humanDefenseTwo) ;
            if (AttackByOne <=0){
                AttackByOne = 0;
            }
            playerTwoLife = playerTwoLife - AttackByOne;
            //console.append("line1AttackbyOne " + humanNameOne + " attacked for " + AttackByOne + ".\n" + humanNameTwo + " has " + playerTwoLife + " health left." + "\n");
            if (playerTwoLife <= 0){
                int calculatedExperience = ExperienceActions.calculateExperience(ExperienceActions.levelCalculator(ExperienceActions.exportExperienceStats(humanNameOne)),ExperienceActions.levelCalculator(ExperienceActions.exportExperienceStats(humanNameTwo)));
                ExperienceActions.importExperienceStats(calculatedExperience, humanNameOne);
                int calculatedMoney = MoneyActions.calculateMoney(ExperienceActions.levelCalculator(ExperienceActions.exportExperienceStats(humanNameOne)));
                System.out.println(calculatedMoney + " calc money in battle");
                MoneyActions.importMoneyStats(calculatedMoney,humanNameOne);
                Battlelog.add(humanNameOne + " attacked for " + AttackByOne + ". " + "\n" + humanNameTwo + " lost the battle.\n");
                Battlelog.add(humanNameOne + " gained " + calculatedExperience + " experience.\n");
                Battlelog.add(humanNameOne + " picked up " + calculatedMoney + " coins.\n");
                break;
            }else if (playerTwoLife >0){
                Battlelog.add("" + humanNameOne + " attacked for " + AttackByOne + ". " + humanNameTwo + " has " + playerTwoLife + " health left." + "\n");
            }

            int AttackByTwo;
            AttackByTwo = determineAttack(humanAttackTwo) - determineDefense(humanDefenseOne);
            if (AttackByTwo <=0){
                AttackByTwo = 0;
            }
            playerOneLife = playerOneLife - AttackByTwo;
            //console.append("line1AttackbyTwo" +  humanNameTwo + " attacked for " + AttackByTwo + ".\n" + humanNameOne + " has " + playerOneLife + " health left." + "\n");
            if (playerOneLife <= 0){
                int calculatedExperience = ExperienceActions.calculateExperience(ExperienceActions.levelCalculator(ExperienceActions.exportExperienceStats(humanNameTwo)),ExperienceActions.levelCalculator(ExperienceActions.exportExperienceStats(humanNameOne)));
                ExperienceActions.importExperienceStats(calculatedExperience, humanNameTwo);
                int calculatedMoney = MoneyActions.calculateMoney(ExperienceActions.levelCalculator(ExperienceActions.exportExperienceStats(humanNameTwo)));
                MoneyActions.importMoneyStats(calculatedMoney,humanNameTwo);
                Battlelog.add(humanNameTwo + " attacked for " + AttackByTwo + ". " + "\n" + humanNameOne + " lost the battle.\n");
                Battlelog.add(humanNameTwo + " gained " + calculatedExperience + " experience.\n");
                Battlelog.add(humanNameTwo + " picked up " + calculatedMoney + " coins.\n");
                break;

            }else if (playerOneLife > 0){
                Battlelog.add("" + humanNameTwo + " attacked for " + AttackByTwo + ". " + humanNameOne + " has " + playerOneLife + " health left." + "\n");
            }
        }
        for (String s : Battlelog) {
            console.append(s);
        }

        return "Battled";

    }
}
