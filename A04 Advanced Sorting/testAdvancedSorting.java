// Name: Charlie McLarty
// Class: CS 4306/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: Intellij

// Algorithm Design Block
/*
I found the merge sort to be the best overall sorting algorithm in terms of comparisons, but it is also not in place
which may make it not ideal for some situations. It performs even faster when the array is already in order ascending
or descending. It performs O(nlogn) for best and worst case.

Quick sort performed about the same as heapsort when the values were random (O(nlogn), but it performed close to O(n^2) when the
values were ascending or descending causing stack overflow on larger sized arrays. I recommend this algorithm when you
have random elements.

Heapsort performed about the same as quicksort on random values, and it scaled proportionally with n whether it was
random, increasing, or decreasing values. Heapsort would be more efficient when you already have a heap made as making
the heap was the most intensive process. It performed close to O(nlogn) for all variations.
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class testAdvancedSorting {
    static Quicksort qs = new Quicksort();
    static Mergesort ms = new Mergesort();
    static Heapsort hs = new Heapsort();
    public static void main(String[] args) {
        ArrayList<int[]> arrays = new ArrayList<>();
        long[] randomComparisons = new long[12];
        long[] increasingComparisons = new long[12];
        long[] decreasingComparisons = new long[12];
        Scanner sc = new Scanner(System.in);
        int menuOption = 0;
        while (menuOption != 4 ){
            System.out.print("""
                    --------MAIN MENU-------
                    1. Populate All Arrays
                    2. Run Algorithms
                    3. Display outputs
                    4. Exit Program
                    
                    Enter option number:\s""");
            menuOption = sc.nextInt();
            if (menuOption == 1){
                //Create all array variations
                arrays = new ArrayList<>();
                int size = 1000;
                for (int i = 0;  i < 4; i++){
                    arrays.add(createRandomArray(size));
                    arrays.add(createIncreasingArray(size));
                    arrays.add(createDecreasingArray(size));
                    size *= 10;
                }
            }else if (menuOption == 2){
                //Calls all sorting algorithms in the order they will be printed later and adds to appropriate array
                if (arrays.size() == 12){
                    randomComparisons = new long[12];
                    increasingComparisons = new long[12];
                    decreasingComparisons = new long[12];

                    long[] comparisonsArray = randomComparisons;
                    int comparisonsIndex = 0;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 4; j++) {
                            ms.sort(arrays.get(j * 3 + i));
                            comparisonsArray[comparisonsIndex] = ms.comparisons;
                            ms.comparisons = 0;

                            qs.sort(arrays.get(j * 3 + i));
                            comparisonsArray[comparisonsIndex + 4] = qs.comparisons;
                            qs.comparisons = 0;

                            hs.sort(arrays.get(j * 3 + i));
                            comparisonsArray[comparisonsIndex + 8] = hs.comparisons;
                            hs.comparisons = 0;

                            comparisonsIndex++;
                        }
                        comparisonsIndex = 0;
                        //Changes the array after every j loop
                        if (comparisonsArray == randomComparisons) {
                            comparisonsArray = increasingComparisons;
                        } else {
                            comparisonsArray = decreasingComparisons;
                        }
                    }
                }else {
                    System.out.println("Please populate arrays first");
                }
            }else if (menuOption == 3){
                //Prints final results
                if (randomComparisons[0] != 0){
                    System.out.println("\nArray type: Random");
                    printDetails(randomComparisons);
                    System.out.println("\nArray type: Increasing");
                    printDetails(increasingComparisons);
                    System.out.println("\nArray type: Decreasing");
                    printDetails(decreasingComparisons);
                }else{
                    System.out.println("Please run the algorithms first");
                }
            }else if (menuOption != 4){
                System.out.print("Please enter an option 1-4");
            }
            System.out.print("\n");
        }
    }

    //Prints sorting results in tabular format
    public static void printDetails(long[] comparisons) {
        System.out.println("Algorithm\t\tn=1000\t\tn=10000\t\tn=100000\tn=1000000");
        System.out.println("------------------------------------------------------------");
        System.out.print("Mergesort\t\t");
        System.out.println(comparisons[0] + "\t\t" + comparisons[1] + "\t\t" + comparisons[2] + "\t\t" + comparisons[3]);
        System.out.print("Quicksort\t");
        //Checks for stackoverflow (indicated by -1 comparisons)
        for (int i = 4; i < 8; i++){
            if (comparisons[i] == -1){
                System.out.print("SOE\t\t\t");
            }else{
                System.out.print("\t" + comparisons[i] + "\t");
            }
        }
        System.out.print("\nHeapsort\t\t");
        System.out.println(comparisons[8] + "\t\t" + comparisons[9] + "\t\t" + comparisons[10] + "\t\t" + comparisons[11]);
    }

    //Generates random array of non-distinct values
    public static int[] createRandomArray(int size){
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            array[i] = random.nextInt(size) + 1;
        }
        return array;
    }

    //Generates array from 1 to n
    public static int[] createIncreasingArray(int size){
        int[] array = new int[size];
        for (int i = 1; i <= size; i++){
            array[i-1] = i;
        }
        return array;
    }

    //Generates array from n to 1
    public static int[] createDecreasingArray(int size){
        int[] array = new int[size];
        for (int i = size; i > 0; i--){
            array[size - i] = i;
        }
        return array;
    }

    //Prints array (for testing/debugging)
    public static void printArray(int[] a){
        for (int i : a) {
            System.out.print(i + ",\s");
        }
        System.out.print("\n");
    }
}
