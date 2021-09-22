import java.util.Random;
import java.util.Scanner;

public class HW2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random rnd = new Random();

    public static void main(String[] args) {
        System.out.println("1. Sort descending");
        int[] firstArray = new int[]{2, 3, 1, 7, 11};
        System.out.println("Original array");
        printArray(firstArray);
        sortArrayDesc(firstArray);
        System.out.println("Sorted array");
        printArray(firstArray);
        System.out.println("==============================================");

        System.out.println("2. Sum of positive elements");
        System.out.print("Enter array size: ");
        int arraySize = scanner.nextInt();
        int[] secondArray = createRandomArray(arraySize);
        printArray(secondArray);
        int sum = findPositiveSum(secondArray);
        System.out.println("All positive sum = " + sum);
        System.out.println("==============================================");

        System.out.println("3. Array average");
        System.out.print("Enter array size: ");
        arraySize = scanner.nextInt();
        int[] thirdArray = createRandomArray(arraySize);
        printArray(thirdArray);
        double average = findAverage(thirdArray);
        System.out.println("Average = " + average);
        System.out.println("==============================================");

        System.out.println("4. Remove duplicates");
        int[] fourthArray = new int[]{3, 2, 3, 1, 4, 2, 8, 3};
        System.out.println("Original array");
        printArray(fourthArray);
        removeDuplicates(fourthArray);
        System.out.println("Without duplicates array");
        printArray(fourthArray);
        System.out.println("==============================================");
    }

    private static void removeDuplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    array[j] = 0;
                }
            }
        }
    }

    private static double findAverage(int[] array) {
        double average = 0;
        for (int j : array) {
            average += j;
        }
        return average / array.length;
    }

    private static int findPositiveSum(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum = j > 0 ? j + sum : sum;
        }
        return sum;
    }

    private static int[] createRandomArray(int arraySize) {
        //Array auto init, diapason - (-bound; +bound)
        int bound = 40;
        int[] arr = new int[arraySize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(bound);
            if (rnd.nextDouble() > 0.5) {
                arr[i] *= -1;
            }
        }
        return arr;
    }

    private static void sortArrayDesc(int[] array) {
        //Bubble sort
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] > array[i - 1]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    isSorted = false;
                }
            }
        }
    }

    private static void printArray(int[] firstArray) {
        System.out.print("[ ");
        for (int j : firstArray) {
            System.out.print(j + " ");
        }
        System.out.println(']');
    }
}