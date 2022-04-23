package Amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ServerPower {

    public static void main(String[] args){
        List<Integer> l=new ArrayList<>();
        l.add(2);
        l.add(3);
        l.add(2);
        l.add(1);
        System.out.println(findTotalPower(l));
        //System.out.println(getPower(new int[] {2,3,2,1}));
    }


    /*public static int getPower(List<Integer> power){

        int currentSum=0,result=0;
        int currentMin=Integer.MAX_VALUE;
        for(int i=0;i<power.size();i++){
            currentMin=Math.min(currentMin,power.get(i));
            currentSum=currentSum+power.get(i);
            result=result+(currentMin*currentSum);
        }


        return result;
    }*/

    public static int getPower(List<Integer> power) {

        int[] inputArr = new int[power.size()];
        for(int i = 0; i < power.size(); i++) inputArr[i] = power.get(i);


        int n = inputArr.length, k = 1, cur = 0, result = 0;
        int[][] mindp = new int[n][n];

        int[] sum = new int[n + 1];
        for(int num : inputArr) {
            cur += num;
            sum[k++] = cur;
        }

        // create a matrix to find out the minimum integer between index i and j
        for(int i = 0; i < inputArr.length; i++) {
            LinkedList<Integer> stack = new LinkedList<>();
            for(int j = i; j < inputArr.length; j++) {
                while(!stack.isEmpty() && (inputArr[stack.peekFirst()] > inputArr[j])) {
                    stack.removeFirst();
                }
                stack.addLast(j);
                mindp[i][j] = inputArr[stack.peekFirst()];
            }
        }
        // sum up all the possible subarrays using index i and j with the matrix and array
        for(int i = 0; i < inputArr.length; i++) {
            for(int j = i; j < inputArr.length; j++) {
                result += mindp[i][j] * (sum[j + 1] - sum[i]);
            }
        }
        return result;
    }



    public static int findTotalPower(List<Integer> power) {

        int n = power.size();
        int m=1;
        int c=0;
        int res=0;

        int[][] mp=new int [n][n];
        int[] sum= new int[n+1];

        for(int nm: power){
            c+=nm;
            sum[m++]=c;

        }

        for(int i =0;i<power.size();i++){
            LinkedList<Integer> stk = new LinkedList<>();
            for(int j=i;j<power.size();j++){
                while(!stk.isEmpty() && (power.get(stk.peekFirst())>power.get(j))){
                    stk.removeFirst();
                }
                stk.addLast(j);
                mp[i][j]= power.get(stk.peekFirst());
            }
        }
        for(int i=0;i< power.size();i++){
            for(int j=i;j<power.size();j++){
                res+=mp[i][j] * (sum[j+1] - sum[i]);
            }
        }
        return res;

    }
}
