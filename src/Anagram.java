import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {

    public Anagram() {

    }

    public static void main(String[] args){
           List<String> strs=Arrays.asList("eat","tea","ta","ate","nat","bat");

       List<String[]> result= getAnagrams(strs);

       System.out.println(checkInclusion("ab","cbasdejhr"));

    }
//readservice c

    private static List<String[]> getAnagrams(List<String> strs) {
        HashMap<String,Integer> count=new HashMap<>();
        for (String s:strs){
           String currentWord=s;
        }
        return null;
    }




        public static boolean checkInclusion(String s1, String s2) {
            s1 = sort(s1);
            for (int i = 0; i <= s2.length() - s1.length(); i++) {
                if (s1.equals(sort(s2.substring(i, i + s1.length()))))
                    return true;
            }
            return false;
        }

        public static String sort(String s) {
            char[] t = s.toCharArray();
            Arrays.sort(t);
            return new String(t);
        }



}
