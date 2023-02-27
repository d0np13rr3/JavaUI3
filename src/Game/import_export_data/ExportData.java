package Game.import_export_data;

import java.io.FileWriter;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
public class ExportData {

 public static void resetWeapon(String name){
        String spacesName = name.replaceAll(" ","_");
        try {
        FileWriter myWriter = new FileWriter("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\" + spacesName +"WeaponSaveCode.txt",false);
            myWriter.write("");
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
   }

    public static void storeData(String[] data, String itemName, String itemClass) {
        String spacesName = itemName.replaceAll(" ","_");
        String spacesClass = itemClass.replaceAll(" ","_");
        //creating file
        try {
            File myObj = new File("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\" + spacesName + spacesClass +".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //writing to file
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\" + spacesName + spacesClass +".txt");
            for(String dataLine : data){
                myWriter.write(dataLine + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        // verdere dimensies toevoegen aan karakters
        if (spacesClass.equals("CharacterSaveCode")){
            try {
                FileWriter myWriter = new FileWriter("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\" + spacesName +"CharacterSaveCode.txt",true);
                myWriter.write("0001XP" + "\n");
                myWriter.write("0001CURRENCY" + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }

}

