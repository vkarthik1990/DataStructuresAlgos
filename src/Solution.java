import java.util.ArrayList;
import java.util.List;

public class Solution {
/*
N=3
N=3

INPUT MATRIX:
----> colmn as c
1 2 3
4 5 6
7 8 9 rows as K

print pattern expected:
(0,2),
(0,1),(1,2)
(0,0),(1,1),(2,2)
(1,0),(2,1)
(2,0)

traverse pattern : row = row + 1; column = column +1;
no of diagonal = row+column -1 ;

Complexity : O(n) , need to traverse the entire list atleast once.
*/

    public static void printAntiDiag(List<List<Integer>> matrix) {
        int N = matrix.size();
        int row = 0, col = 0;
        List<Integer> elements=new ArrayList<>();
        /*** Traverse along the column ***/
        for(int c=N-1;c>=0;c--){
            row=0;
            col=c;
            while(col<=2){
                elements.add(matrix.get(row).get(col));
                row = row + 1;
                col = col + 1;
            }
        }
        /*** Traverse along the row ***/
        for(int k=1;k<=N-1;k++){
            row=k;
            col=0;
            while(row <= N-1){
                elements.add(matrix.get(row).get(col));
                row=row+1;
                col=col+1;
            }
        }
        /*** print the entire result list ***/
        elements.forEach(System.out::println);
    }



    public static void main(String[] args){
        List<Integer> list=new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> list2=new ArrayList<Integer>(){{
            add(4);
            add(5);
            add(6);
        }};
        List<Integer> list3=new ArrayList<Integer>(){{
            add(7);
            add(8);
            add(9);
        }};

        List<List<Integer>> matrix = new ArrayList<List<Integer>>(){{
            add(list);
            add(list2);
            add(list3);
        }};
        printAntiDiag(matrix);
    }

}
