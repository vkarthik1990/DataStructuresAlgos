import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {

    public Anagram() {

    }

    public static void main(String[] args){
           List<String> strs=Arrays.asList("eat","tea","ta","ate","nat","bat");

       List<String[]> result= getAnagrams(strs);

    }
//readservice c

    private static List<String[]> getAnagrams(List<String> strs) {
        HashMap<String,Integer> count=new HashMap<>();
        for (String s:strs){
           String currentWord=s;
        }
        return null;
    }


}
