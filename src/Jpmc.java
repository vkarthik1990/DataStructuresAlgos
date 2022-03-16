import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Jpmc {

    public static void main(String[] args) throws IOException, AlsCustomException {
        System.out.println("[DEBUG]:"+ breakPalindrome("bab"));
        System.out.println("[DEBUG]:"+ breakPalindrome("aaa"));
       /* InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null && line.equalsIgnoreCase("")) {
            System.out.println(line);
        }
        if(!line.contains(",") || line.chars().filter(ch -> ch == ',').count()>1){
            throw new AlsCustomException("improper string");
        }
        String mainTxt=line.split(",")[0];
        String trimTxt=(line.split(",")[1]).trim();

        for(char c: trimTxt.toCharArray()){
            mainTxt=mainTxt.replaceAll(String.valueOf(c),"");
        }
        System.out.println("[DEBUG]:"+mainTxt);*/
    }

    static class AlsCustomException extends Exception
    {
        public AlsCustomException(String message)
        {
            super(message);
        }
    }

    public static String breakPalindrome(String palindromeStr) {
        int length = palindromeStr.length();
        if (length == 1) {
            return "IMPOSSIBLE";
        }
        // Strings are immutable in Java, convert it into a char array
        char[] pd_Arr = palindromeStr.toCharArray();

        for (int i = 0; i < length / 2; i++) {
            if (pd_Arr[i] != 'a') {
                pd_Arr[i] = 'a';
                return String.valueOf(pd_Arr);
            }
        }

        pd_Arr[length - 1] = 'b';
        return String.valueOf(pd_Arr);
    }
}
