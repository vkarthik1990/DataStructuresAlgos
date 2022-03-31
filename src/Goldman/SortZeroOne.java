package Goldman;

import java.util.Arrays;

public class SortZeroOne {


    public static int[] getSortedArr(int[] arr){
        int i=0;
        int j=arr.length-1;
        if(arr.length== 0 || arr==null) return null;
        while(i!=j){
            if(arr[i]==0) {
                if (arr[j] == 0) {
                    j--;
                } else {
                    arr[i] = 1;
                    arr[j] = 0;
                }
            }else{
                i++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] a={1,0,1,0,1,1,1,1,1};
        int[] b={0,0,0,0,0,0,0,0,0};
        int[] c={};
        System.out.println(Arrays.toString(getSortedArr(a)));
        System.out.println(Arrays.toString(getSortedArr(b)));
        System.out.println(Arrays.toString(getSortedArr(c)));
    }

}
