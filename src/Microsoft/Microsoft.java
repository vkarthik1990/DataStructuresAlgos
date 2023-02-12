package Microsoft;

//import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.IntStream;

public class Microsoft {

    public static char character_const='a';

    public static void main(String[] args) {
        System.out.println("[DEBUG]:"+solution("babaa"));
        int array[] = { 10, 1,3,1,2,2,1,0, 4 };
        maxNonOverlapSeg(array);

        int a[] = { 1,2,4,4,3 };
        int b[] = { 2,3,1,3,1 };
        validPath(4,a,b);

        int N = 4;
        int A[] = {1,2,4,4,3};
        int B[] = {2,3,1,3,1};

        System.out.print("Result:" + solution(N,A,B));
    }
    public static int solution(String S) {
        char[] myArray = S.toCharArray();
        List<Integer> continuousChar = new ArrayList<>();
        char prev = myArray[0];
        int prev_Length = 1;
        int length = myArray.length;
        for (int i = 1; i < length; i++) {
            if (myArray[i] == prev) {
                prev_Length++;
            } else {
                continuousChar.add(prev_Length);
                prev = myArray[i];
                prev_Length = 1;
            }
        }
        continuousChar.add(prev_Length);

        int maxNumber = continuousChar.stream()
                .max((i, j) -> i.compareTo(j)).get();
        return continuousChar
                .stream()
                .reduce(
                        0,
                        (a, b) -> {
                            return a + maxNumber - b;
                        });

    }


    public static int maxNonOverlapSeg(int[] A){
        int array_size=A.length;
        int max_segments=0;

        for(int i=0;i+1<array_size;i++){
            int sum = A[i]+A[i+1];
            int j=i+2;
            int segment_cnt =1;

            while(j+1<array_size){
                if(A[j]+A[j+1]==sum){
                    ++segment_cnt;
                    j+=2;
                }else{
                    j+=1;
                }
                max_segments=Integer.max(max_segments,segment_cnt);
            }
        }
        System.out.println("[DEBUG] max count:"+max_segments);
        return max_segments;
    }

    public static boolean validPath(int N,int[] A,int[] B){

        Map<Integer,List<Integer>> graph=new HashMap<>();

        for(int i=0;i<A.length;i++){
            graph.computeIfAbsent(A[i],x->new ArrayList<>()).add(B[i]);
            graph.computeIfAbsent(B[i],x->new ArrayList<>()).add(A[i]);
        }

        Stack<Integer> stack =new Stack<>();
        Set<Integer> seen = new HashSet<>();
        stack.push(1);
        return false;
    }














    /////

    public static int max(int [] array) {
        int max = 0;

        for(int i=0; i<array.length; i++ ) {
            if(array[i]>max) {
                max = array[i];
            }
        }
        return max;
    }

    public static boolean solution(int N, int []A, int[] B) {
        int[] vertex = IntStream.concat(Arrays.stream(A), Arrays.stream(B)).toArray();
//int A[] = {1,2,4,4,3};
//        int B[] = {2,3,1,3,1};
        int size = max(vertex);
        boolean graph[][]  =  new boolean[size][size];

        for(int i=0;i<A.length;i++){
            int row = A[i];
            int col = B[i];
            graph[row-1][col-1]=true;
        }

        boolean result = true;
        for( int i = 0; i< N-1; i++) {
            if(!(graph[i][i+1] || graph[i+1][i])){
                return false;
            }
        }
        return result;
    }
}




