import java.util.ArrayList;
import java.util.List;

/***
 *
 * Large number calculator
 *
 * Define 4 kinds of ops:
 *
 * Add
 * Sub
 * Multiply
 * Divide
 *
 * You can choose  only 1 operation to implement
 * E.g.:
 *
 * 1232131321313213123132121 + 3213213123213131313 = 1232134534526336336263434
 *
 * Tips:
 *
 * Reflect some kind of design ability/OOP concepts/ abstraction
 * Runnable code is a big plus
 *
 *
 */


abstract class Operations{

    /***
     *
     *
     *
     * ***/
    public String add(String a,String b){

        List<Integer> first=new ArrayList<>();
        List<Integer> second = new ArrayList<>();
       for(char c:a.toCharArray()){
           first.add(Integer.parseInt(c+""));
       }
        for(char d:b.toCharArray()){
            second.add(Integer.parseInt(d+""));
        }
        int n = first.size();
        int s= second.size();
        int index= (n<s)? n : s;

        StringBuffer sb=new StringBuffer();
        int carry=0;
        for(int i=index-1;i>=0;i--){
            int result= (carry!=0) ? first.get(i)+second.get(i)+carry : first.get(i)+second.get(i);
            carry= result/10;
            if(carry!=0) {
                result=result%10;
            }

            sb.append(result);
        }

        sb.append(carry);

        return sb.reverse().toString();
    }



}
public class Calculator extends Operations {

    public static void main(String[] args){
        Calculator c=new Calculator();
        System.out.println(c.add("1232131321313213123132121","3213213123213131313"));
    }


}
