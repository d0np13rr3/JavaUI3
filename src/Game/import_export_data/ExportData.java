package Game.import_export_data;

import java.io.FileWriter;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
public class ExportData {

    public static void storeData(String[] data, String itemName, String itemClass) {
        //creating file
        try {
            File myObj = new File("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\" + itemName + itemClass +".txt");
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
            FileWriter myWriter = new FileWriter("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\" + itemName + itemClass +".txt");
            for(String dataLine : data){
                myWriter.write(dataLine + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}

