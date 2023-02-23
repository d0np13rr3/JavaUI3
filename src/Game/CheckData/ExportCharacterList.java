package Game.CheckData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.Scanner;

public class ExportCharacterList {

    public static String[] exportCharacterList() {
        ArrayList<String> names = new ArrayList<String>();
        String[] namesArray;
        try {
            File myObj = new File("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\CharacterList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                names.add(data);

            }
            myReader.close();
            namesArray = names.toArray(new String[0]);
            return namesArray;

        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }return null;
    }
}
