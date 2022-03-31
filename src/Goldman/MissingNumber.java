package Goldman;

import java.util.Arrays;

public class MissingNumber {

    public static int getMissingNumber(int[] nums){
        int missing=nums.length;

        for(int i=0;i<nums.length;i++){
            missing^= i^nums[i];
        }
        return missing;
    }


    public static void main(String[] args) {
        int[] a={0,1,2,3,4,6,7,8};
        int[] b={0,2,1,3,5,8,7,6};

        System.out.println(getMissingNumber(a));
        System.out.println(getMissingNumber(b));

    }

}
