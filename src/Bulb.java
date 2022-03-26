import java.util.*;
import java.util.stream.IntStream;


public class Bulb {
    public static void main(String[] args) {
        // int A[] = {2,1,3,5,4}; //3
        // int A[] = {2,3,4,1,5}; // 2
        int A[] = {1,3,4,2,5}; //3
        int OnCount = Solution(A);
        System.out.println(OnCount);


    }
    public static boolean checkOn(boolean [] A, int i) {
        if(i==0 && A[i]){
            return true;
        }
        if(i>0 ) {
            return A[i] ? checkOn(A,i-1) : false;
        }
        return false;
    }
    public static int Solution(int [] A) {
        int OnCount = 0;
        boolean [] OnState = new boolean[A.length];
        for (int i = 0; i < A.length; i++) {
            OnState[A[i]-1] = true;
            if(checkOn(OnState, i)){
                OnCount++;
            }
        }
        return OnCount;
    }
}
