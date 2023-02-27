package Game.import_export_data;

public class ImportData {

    public static String addRealTrailingZeroes(String s) {
       String StringZeroes = "";
       int numDigits = 4;
       int numZeroes = numDigits - (s.length());
       for (int i = 0; i < numZeroes; i++) {
           StringZeroes = StringZeroes + "0";
        }
        s = StringZeroes + s;
        return s;
    }
}
