package Goldman;

public class RotateArray {

    /***
     *
     * Input = [1,4,5,3,2] k=2
     * Output = [3,2,1,4,5]
     *
     */

    public static int[] rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a={0,1,2,3,4,6,7,8};
        int[] b={0,2,1,3,5,8,7,6};
       int[] result= rotate(a,3);
       for(int i:result) System.out.print(i);


    }
}
