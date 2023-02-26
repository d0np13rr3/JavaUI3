package Game.import_export_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExportNameAndClass {

    public static String[] exportCharacterStats(String name) {

        ArrayList<String> Stats = new ArrayList<String>();
        String[] statsArray;
        try {
            File myObj = new File("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\" + name + "CharacterSaveCode.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Stats.add(data);

            }
            myReader.close();
            statsArray = Stats.toArray(new String[0]);
            return statsArray;

        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }return null;
    }

    public static String[] exportWeaponStats(String name) {

        ArrayList<String> Stats = new ArrayList<String>();
        String[] statsArray;
        try {
            File myObj = new File("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\" + name + "WeaponSaveCode.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Stats.add(data);

            }
            myReader.close();
            statsArray = Stats.toArray(new String[0]);
            return statsArray;

        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }return null;
    }
}
