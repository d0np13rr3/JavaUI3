package Game.CheckData;

public class CasingMethods {

    public static String toTitleCaseOneWord(String givenString) {
        int lengthString = givenString.length();
        String newString = givenString.substring(0, 1).toUpperCase() + givenString.substring(1).toLowerCase();
        return newString;
    }
}
