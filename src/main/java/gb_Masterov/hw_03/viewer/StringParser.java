package gb_Masterov.hw_03.viewer;

public class StringParser {
    public String[] getDataFromString(String inputString){
        String[] result = inputString.split(" ");
        return result;
    }
}
