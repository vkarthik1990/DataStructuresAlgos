package Goldman;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqChar {

    public static int getFirstUniqChar(String s){
        Map<Character,Integer> count=new HashMap<Character, Integer>();

        for(char c: s.toCharArray()){
            count.put(c,count.getOrDefault(c,0)+1);
        }

        for(int i=0;i<count.size();i++){
            if(count.get(s.charAt(i))==1) return i;
        }

        return -1;

    }
    public static void main(String[] args) {

        System.out.println(getFirstUniqChar("karthik"));
        System.out.println(getFirstUniqChar("aabbcc"));

    }
}
