package Sort;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        quicksort(numbers,0,numbers.length-1);

        System.out.println("\nAfter:");
        printArray(numbers);
    }

    private static void quicksort(int[] numbers, int lowIndex, int highIndex) {

        if(lowIndex>=highIndex){
            return;
        }
        int pivotIndex=new Random().nextInt(highIndex-lowIndex)+lowIndex;
        int pivot = numbers[pivotIndex];
        swapArray(numbers,highIndex,pivotIndex);

        int leftPointer = partition(numbers, lowIndex, highIndex, pivot);

        quicksort(numbers, lowIndex, leftPointer - 1);
        quicksort(numbers, leftPointer + 1, highIndex);


    }

    private static int partition(int[] numbers, int lowIndex, int highIndex, int pivot) {
        int leftpointer=lowIndex;
        int rightpointer = highIndex-1;

        while(leftpointer<rightpointer){

            while(numbers[leftpointer]<=pivot && leftpointer<rightpointer){
                leftpointer++;
            }
            while(numbers[rightpointer]>=pivot && leftpointer<rightpointer){
                rightpointer--;
            }
            swapArray(numbers,leftpointer,rightpointer);
        }

        if(numbers[leftpointer]>numbers[highIndex]) {
            swapArray(numbers, leftpointer, highIndex);
        }else{
            leftpointer=highIndex;
        }
        return leftpointer;
    }


    private static void swapArray(int[] arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
