import java.util.*;
import java.util.stream.IntStream;

public class BinaryEncodeGrab {
    public static void main(String[] args) {
        // Case 1
        StringBuffer sb= new StringBuffer("011100");
        int count = Solution(removeZero(sb.toString()));
        System.out.println(count);
        // Case 2
        sb= new StringBuffer("111");
        count = Solution(removeZero(sb.toString()));
        System.out.println(count);
        // Case 3
        sb= new StringBuffer("1111010101111");
        count = Solution(removeZero(sb.toString()));
        System.out.println(count);
        // Case 4
        sb= new StringBuffer();
        for(int i = 0 ; i< 400000; i++)
        {
            sb.append('1');
        }
        count = Solution(removeZero(sb.toString()));
        System.out.println(count);


    }

    public static String removeZero(String str)
    {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0')
            i++;

        StringBuffer sb = new StringBuffer(str);

        sb.replace(0, i, "");

        return sb.toString();
    }
    public static int Solution(String s) {
        int steps=0;
        StringBuffer sb= new StringBuffer(s);
        while(sb.length()>0){
            char a = sb.charAt(sb.length()-1);

            if(a == '1') {
                steps= sb.length() > 1 ? steps+2 : steps+1 ;
            } else {
                steps= steps+1;
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return steps;
    }
}