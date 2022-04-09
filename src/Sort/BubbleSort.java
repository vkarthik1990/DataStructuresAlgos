package Sort;

import java.util.Random;

/***
 * Reference: https://www.codepile.net/pile/aNVb5kNb
 *
 * https://www.youtube.com/watch?v=g8qeaEd2jTc
 *
 * ***/
public class BubbleSort {

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        bubblesort(numbers);

        System.out.println("\nAfter:");
        printArray(numbers);
    }

    private static void bubblesort(int[] numbers) {

        boolean swapedSomething = true;
        while(swapedSomething){
            swapedSomething = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    swapedSomething=true;
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }

    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
