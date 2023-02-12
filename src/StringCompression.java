
import java.util.Stack;

public class StringCompression {

    //Refference : https://www.youtube.com/watch?v=IhJgguNiYYk
    public int compress(char[] chars){
        int index=0;
        int i=0;
        while(i < chars.length ){
            int j=i;
            while (j <chars.length && chars[i] == chars[j] ){
                j++;
            }
            chars[index++]=chars[i];
            if(j-i > 1){
                    String count = (j-i) +"";
                    for(char c:count.toCharArray()) {
                        chars[index++] = c;
                    }
            }
            i=j;
        }
        System.out.println(chars);
        return index;
    }

    public static String compress(String s){

        StringBuffer sb=new StringBuffer();
        int count=0;
        Character prevChar=null;
        for(char c:s.toCharArray()){
            if(count==0) sb.append(String.valueOf(c));
           if(prevChar!=null && prevChar!=c){
               sb.append(String.valueOf(count));
               prevChar=c;
               count=-1;
           }
            prevChar=c;
            count++;
        }



        return sb.toString();
    }
    public static void main(String[] args){
        String str="aaaabbbcccd";
        StringCompression obj=new StringCompression();
        System.out.println(compress(str));
        System.out.println(obj.compress(new char[] {'a','b','b','b','b','b','b'}));

        String input = "AABBBCMMMAACCCCC";
        System.out.println(compress_standatd_charted(input));
    }


    // package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3


        // Input:  AABBBCMMMAACCCCC
        // Output: A2B3C1M3A2C5
        static String compress_standatd_charted(String s) {
            StringBuffer sb =new StringBuffer();
            Character prev=null;
            int count=0;

            if(s==null || s.isEmpty())return "";
            for(char c:s.toCharArray()){

                System.out.println("inp char: "+c);

                if(count==0) sb.append(c);
                if(prev!=null && prev!=c){
                    sb.append(String.valueOf(count));
                    sb.append(String.valueOf(c));
                    System.out.println("cnt added:"+count);
                    prev=c;
                    count=0;
                    System.out.println("char: "+c+" count:"+count);
                }
                prev=c;
                count++;
            }
            sb.append(String.valueOf(count));
            return sb.toString();
        }






}
