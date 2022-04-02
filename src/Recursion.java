import java.util.Arrays;

public class Recursion {

    public static void main(String[] args){
       System.out.println(fib(10));
       System.out.println(nonRecursiveFib(10));
    }

    //Fibonacci series using recursion :
    public static int fib(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return fib(n-1)+fib(n-2);
    }
    //reverse a linkedlist in recursion
    public static void printReversedLinkedList(Node head){
        if(head == null) return ;
        printReversedLinkedList(head.next);
        System.out.println(head.val);
    }

    public static int nonRecursiveFib(int n){
        if(n<=1) return n;

        int first=0;
        int second=1;
        int nth =1;

        for(int i=2;i<=n;i++){
            nth=first+second;
            first=second;
            second=nth;
        }

        return nth;
    }


}
