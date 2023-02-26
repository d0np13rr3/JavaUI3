package Game.import_export_data;

import Game.CheckData.ExportCharacterList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MoneyActions {
    public static int exportMoneyStats(String name) {
        String spacesName = name.replaceAll(" ","_");

        ArrayList<String> Stats = new ArrayList<String>();
        String[] statsArray;
        try {
            File myObj = new File("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\" + spacesName + "CharacterSaveCode.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Stats.add(data);
            }
            myReader.close();
            statsArray = Stats.toArray(new String[0]);
            int moneyToReturnString = Integer.parseInt(statsArray[4].substring(0,4));
            return moneyToReturnString;

        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }return 0;
    }
    public static void importMoneyStats(int moneyToAdd, String spacesName){
        String name = spacesName.replaceAll(" ","_");

        exportMoneyStats(name);
        int sumOfMoney = moneyToAdd + exportMoneyStats(name);
        String currencyMoney = sumOfMoney + "CURRENCY";
        String charArray[] = ExportCharacterList.exportCharacterList();
        charArray[4] = currencyMoney;
        //writing to file
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\" + spacesName + "CharacterSaveCode.txt");
            for(String dataLine : charArray){
                myWriter.write(dataLine + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public int calculateMoney(int levelProtagonist, int levelAntagonist){


        int levelDifference = levelAntagonist - levelProtagonist;
        Random random = new Random();
        int randomInteger = random.nextInt(10);
        int moneyToReturn = levelDifference * randomInteger;


        return moneyToReturn;
    }
}