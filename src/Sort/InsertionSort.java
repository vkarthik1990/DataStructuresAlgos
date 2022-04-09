package Sort;

import java.util.Random;

public class InsertionSort {


    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        insertionsort(numbers);

        System.out.println("\nAfter:");
        printArray(numbers);
    }
    /******
     *
     *  [3,1,8,6,2]
     *
     *  [1,3,8,6,2] ->  [1,3,8,6,2] ->  [1,3,6,8,2] -> [1,2,3,6,8]
     *
     *
     *
     *
     * *****/
    private static void insertionsort(int[] numbers) {
        for(int i=1;i<numbers.length;i++){
            int currentValue=numbers[i];
            int j=i-1;
            while(j>=0 && numbers[j] > currentValue){
                numbers[j+1]=numbers[j];
                j--;
            }
            numbers[j+1]=currentValue;

        }
    }


    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
