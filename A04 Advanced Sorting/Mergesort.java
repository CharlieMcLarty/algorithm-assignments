// Name: Charlie McLarty
// Class: CS 4306/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: Intellij

import java.util.Arrays;

public class Mergesort {
    public long comparisons;
    public Mergesort(){
        comparisons = 0;
    }

    public void sort(int[] a){
        //Prevents original array being modified - just want comparisons
        int[] temp = Arrays.copyOf(a, a.length);
        runMergeSort(temp);
    }

    public void runMergeSort(int[] a){
        if (a.length > 1) {
            //Split array in half until they're size 1
            int[] b = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] c = Arrays.copyOfRange(a, a.length / 2, a.length);
            //Sort each half
            runMergeSort(b);
            runMergeSort(c);
            int aPointer = 0;
            int bPointer = 0;
            int cPointer = 0;
            //Merge step with pointers to each half incrementing the larger pointer
            while (bPointer < b.length && cPointer < c.length) {
                comparisons++;
                if (b[bPointer] <= c[cPointer]) {
                    a[aPointer] = b[bPointer];
                    bPointer++;
                } else {
                    a[aPointer] = c[cPointer];
                    cPointer++;
                }
                aPointer++;
            }
            //Add the leftover half once one pointer finishes its half
            while (bPointer < b.length) {
                a[aPointer] = b[bPointer];
                bPointer++;
                aPointer++;
            }
            while (cPointer < c.length) {
                a[aPointer] = c[cPointer];
                cPointer++;
                aPointer++;
            }
        }
    }
}
