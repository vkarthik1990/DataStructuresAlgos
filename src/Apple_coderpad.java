import java.io.*;
import java.util.*;
import java.util.Stack;
import java.lang.*;
import java.util.regex.Pattern;

public class Apple_coderpad {
    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */
        public static String[] candidates = {
                // Valid
                "racecar",
                "Kayak",
                "never odd or even",
                "rats live on no evil star",
                "A Toyota! Race fast... safe car: a Toyota",
                "Some men interpret nine memos",
                // Invalid
                "wombat",
                "No lemons, one melon", // lemons, one->lemon, no
                "Too bad – I hid a book", // book->boot
                "No trace; not one cartoon", // cartoon->carton
                "Ma'am, I'm Adam", // Ma'am->Madam
                "Del was a sled", // was->saw
                "Flee to Em, remote elf", // Em->me
                "Ma? Ha! A sham!" // Ha! A sham->Has a ham
        };

        public static Boolean isPalindrome(String candidate) {
            candidate=trimSplChar(candidate);
            String reverse_str=getReversedString(candidate);
            return candidate.equals(reverse_str);
            // Make this work
            // return false;
        }

        public static String getReversedString(String str){
            StringBuffer sb =new StringBuffer();
            Stack<Character> st=new Stack<Character>();
            for(char c:str.toCharArray()){
                st.push(c);
            }
            for(int i=0;i<str.length();i++) sb.append(st.pop());
            return sb.toString();
        }

        public static String trimSplChar(String candidate)
        {
            // System.out.println("trim output : "+candidate.replaceAll(" ", ""). replaceAll("[^a-zA-Z0-9]", " "));
            return candidate.replaceAll("[^a-zA-Z0-9]", " ").replaceAll(" ", "");
        }

        public static void main(String[] args) {
            for (String candidate : candidates) {
                System.out.println(candidate + ": " + isPalindrome(candidate.toLowerCase()));
            }
        }


}
