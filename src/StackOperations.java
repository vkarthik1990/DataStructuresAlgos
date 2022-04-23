import java.io.*;
import java.util.*;


class Stack {
    int limit = (int) (Math.pow(2,20)-1);
    ArrayList<Integer> data= new ArrayList<>();

    Integer pop() throws Exception  {
        if(data.size()==0){
            throw new Exception("Zero Size");
        }
        return data.remove( data.size() - 1 );
    }

    void push(Integer input) throws Exception  {
        if(input>limit) {
            throw new Exception("More than "+limit+"number:"+ input);
        } else if(input < 0 ) {
            throw new Exception("negative number:s"+input);
        }
        data.add(input);
    }

    void dup() {
        data.add(data.get( data.size() - 1 ));
    }
}

class StackOperations {

    public int solution(String s) {
        Stack stack = new Stack();
        int result=-1;
        //   String instru4ction [] = s.split("");
        List<String> instruction = new ArrayList<>(Arrays.asList(s.split(" ")));
        int index = 0;
        try {
            while(index < instruction.size()){
                String data = instruction.get(index);
                if(data.equalsIgnoreCase("POP")) {
                    stack.pop();

                } else if(data.equalsIgnoreCase("DUP")) {
                    stack.dup();
                } else if(data.equalsIgnoreCase("+")) {
                    Integer a =    stack.pop();
                    Integer b =    stack.pop();
                    Integer sum  = a+b;
                    stack.push(sum);

                } else if(data.equalsIgnoreCase("-")) {
                    Integer a =    stack.pop();
                    Integer b =    stack.pop();
                    Integer sub  = a-b;
                    stack.push(sub);
                } else {
                    int num = Integer.parseInt(data);
                    stack.push(num);
                }
                index++;
            }
            return stack.pop();


        } catch( Exception e){
            return -1;

        }
    }

}

class DSolution{
    public static void main(String[] args) throws IOException {

        StackOperations result = new StackOperations();
        // System.out.println(result.solution("4 5 6 - 7 +"));
        // System.out.println(result.solution("13 DUP 4 POP 5 DUP + DUP + -"));
        // System.out.println(result.solution("5 6 + -"));
        System.out.println(result.solution("1048575 DUP +"));




    }
}

