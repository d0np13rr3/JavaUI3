package Game.import_export_data;

import Game.import_export_data.ImportData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ExperienceActions {
    public static int exportExperienceStats(String name) {
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
            int moneyToReturnString = Integer.parseInt(statsArray[3].substring(0,4).replaceFirst("^0+(?!$)", ""));
            return moneyToReturnString;

        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }return 0;
    }
    public static void importExperienceStats(int expToAdd, String spacesName){
        String name = spacesName.replaceAll(" ","_");

        exportExperienceStats(name);
        int sumOfExp = expToAdd + exportExperienceStats(name);
        String formatExp = String.valueOf(sumOfExp);
        String formatZeroes = ImportData.addRealTrailingZeroes(formatExp);
        String addExp = formatZeroes + "XP";
        String charArray[] = ExportNameAndClass.exportCharacterStats(name);
        charArray[3] = addExp;
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

    public static int calculateExperience(int levelProtagonist, int levelAntagonist){
        int levelDifference = levelAntagonist - levelProtagonist;
        if (levelDifference < 0){
            levelDifference = 1;
        }
        Random random = new Random();
        int randomInteger = random.nextInt(15);
        int randomInteger00 = random.nextInt(5);
        int experienceToReturn = (levelDifference * randomInteger) + (levelProtagonist * randomInteger00);


        return experienceToReturn;
    }
    public static int levelCalculator(int exp){
            int level = 0;
            if(exp >= 0 && exp < 10) {
                level = 1;
                return level;
            }else if (exp >= 10 && exp < 50){
                level = 2;
                return level;
            }else if (exp >= 50 && exp < 125){
                level = 3;
                return level;
            }else if (exp >= 125 && exp < 275){
                level = 4;
                return level;
            }else{
                return 0;
            }

        }



        }






