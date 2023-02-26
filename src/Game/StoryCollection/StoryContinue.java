package Game.StoryCollection;

import Game.CheckData.ExportCharacterList;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StoryContinue {
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null,
//                "ALERT MESSAGE",
//                "TITLE",
//                JOptionPane.WARNING_MESSAGE);
    }
    public static void writeToStoryFile(int tracker){
        //writing to file
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\Storytracker.txt");
            myWriter.write("%s\n".formatted(tracker));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static int readFromStoryFile(){
        int storyTrackerRead = 0;
        try {
            File myObj = new File("C:\\Users\\ppauwelb\\IdeaProjects\\JavaUI3\\src\\Database\\Storytracker.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                storyTrackerRead = Integer.parseInt(myReader.nextLine());
            }
            myReader.close();
            return storyTrackerRead;
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }return storyTrackerRead;

    }

    public static void StoryContinues() {

        //reading value from Storyfile
        int storyTrackerRead = readFromStoryFile();

        switch (storyTrackerRead) {
            case 0:
                 int lengthCharList000 = ExportCharacterList.exportCharacterList().length;
                 System.out.println(lengthCharList000 + " characters in list");
                 if (lengthCharList000 > 0){
                     infoBox("You passed the first chapter.", "Story advancement");
                     writeToStoryFile(1);
                 }
                break;
            case 1:
                int lengthCharList001 = ExportCharacterList.exportCharacterList().length;
                System.out.println(lengthCharList001 + " characters in list");
                if (lengthCharList001 >= 3){
                    infoBox("You passed the second chapter.", "Story advancement");
                    writeToStoryFile(2);
                }
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;

        }
    }
}
