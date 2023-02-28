package Game.CheckData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ExportCharacterList {

    public static String[] exportCharacterList() {
        ArrayList<String> names = new ArrayList<String>();

        String[] namesArray;
        try {
            File myObj = new File("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\CharacterList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                names.add(data);

            }
            myReader.close();
            Collections.sort(names);
            namesArray = names.toArray(new String[0]);
            return namesArray;

        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }return null;
    }

    public static String[] exportReverseCharacterList(){
        String[] namesReverse =  exportCharacterList();
//        ArrayList<String> namesReverseList = null;
//        Collections.addAll(namesReverseList, namesReverse);
        Arrays.sort(namesReverse, Collections.reverseOrder());
//        String[] reverseNamesArray = namesReverseList.toArray(new String[0]);
        return namesReverse;
    }
}
