// you can also use imports, for example:
import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Grab {
    public static int solution(String S) {
        // write your code in Java SE 8
        final int MODULO=1000000007;
        List<Integer> ones = new ArrayList<Integer>();
        int len = S.length();
        for(int i=0;i<len;i++){
            if(S.charAt(i) == '1' ) ones.add(i);
        }

        int size = ones.size();
        if(size % 3 !=0) return 0;
        if(size==0){
            long ways = (long) (len - 1) * (len - 2)/2;
            return (int) (ways %MODULO);
        }else{
            int index_1 = size/3,index_2 = size /3*2;
            int count_1=ones.get(index_1) - ones.get(index_1-1);
            int count_2= ones.get(index_2) - ones.get(index_2-1);
            long ways = (long) count_1*count_2;
            return (int) (ways % MODULO);
        }
    }

    public static void main(String[] args){
       // System.out.println("[DEBUG]:"+solution("aba"));
        //System.out.println("[DEBUG]:"+solution1("011100"));
        //System.out.println("[DEBUG]:"+solution1("1111010101111"));
        System.out.println("[DEBUG]:"+Solution22("011100"));
        System.out.println("[DEBUG]:"+Solution22("11111"));
    }

    public static int solution1(String s){
        int max_char=s.length();
        int carry_forward=0;
        int result=0;
        for(int i=max_char-1;i>=0;i--)
        {
            if(i==0 && carry_forward==0 ) {
                break;
            }

            char ch=s.charAt(i);
            int j=ch-48;
            j=j+carry_forward;
            if(j%2==0)
            {
                result++;
                if(j==2){
                    carry_forward=1;
                }
            }
            else {
                carry_forward=1;
                result=result+2;
            }
        }
        return result-1;
    }

    public static int solution2(String s){
        int count=0;
        int decimal = binaryToDecimal(s);
        if(decimal<0) return 799999;
        while(decimal>0){
            if(decimal%2==0){
                decimal=decimal/2;
            }else{
                decimal=decimal-1;
            }
            count++;
        }

        return count;
    }

    static int binaryToDecimal(String n)
    {
        String num = n;
        int result = 0;

        int base = 1;

        int len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            if (num.charAt(i) == '1')
                result += base;
            base = base * 2;
        }

        return result;
    }


    public static int Solution22(String s) {
        int steps=0;
        StringBuffer sb= new StringBuffer(s);
        while(sb.length()>0){
            char a = s.charAt(s.length()-1);
            if(a == '1') {
                steps= steps+2;
            } else {
                steps= steps+1;
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return steps;
    }
}
