// Name: Charlie McLarty
// Class: CS 4306/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: Intellij

import java.util.Arrays;

public class Quicksort {
    public long comparisons;
    public Quicksort(){
        comparisons = 0;
    }

    public void sort(int[] a){
        //Copy array so it's not modified
        int[] temp = Arrays.copyOf(a, a.length);
        runQuickSort(temp, 0, temp.length - 1);
    }

    public void runQuickSort(int[] a, int lowIndex, int highIndex){
        if (lowIndex < highIndex){
            //Catch stackoverflow error
            //Set comparisons to -1 if so
            try{
                //Create pointers to find value larger or smaller than the pivot (first number in a)
                int pivot = a[lowIndex];
                int bigger = lowIndex;
                int smaller= highIndex;
                //Partition example from slides
                while (bigger < smaller){
                    while (bigger <= highIndex && a[bigger] <= pivot){
                        comparisons++;
                        bigger++;
                    }
                    while (a[smaller] > pivot){
                        comparisons++;
                        smaller--;
                    }
                    if (bigger < smaller){
                        int temp = a[bigger];
                        a[bigger] = a[smaller];
                        a[smaller] = temp;;
                    }
                }
                //Move pivot to its correct location
                int temp = a[lowIndex];
                a[lowIndex] = a[smaller];
                a[smaller] = temp;
                //Recursively run quick sort on list < and > than pivot
                runQuickSort(a, lowIndex, smaller - 1);
                runQuickSort(a, smaller + 1, highIndex);
            }catch (StackOverflowError e){
                comparisons = -1;
            }
        }
    }
}
