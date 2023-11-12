// Name: Charlie McLarty
// Class: CS 4306/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 4
// IDE: Intellij

import java.util.Arrays;

public class Heapsort {
    public long comparisons;
    public Heapsort() {
        comparisons = 0;
    }

    public void sort(int[] a) {
        //Removes reference to Array so it can be used multiple times
        int[] temp = Arrays.copyOf(a, a.length);
        runHeapSort(temp);
    }

    public void runHeapSort(int[] a){
        //Check all non leaf nodes for smaller children
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            createHeap(a, i, a.length);
        }
        //Add the smallest element to the sorted list and re-heaping the tree afterwards
        for (int i = a.length - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            createHeap(a, 0, i);
        }
    }

    public void createHeap(int[] a, int i, int size) {
        int parent = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        // Check if any children are smaller than the current node
        if (left < size && a[left] > a[parent]) {
            comparisons++;
            parent = left;
        }
        if (right < size && a[right] > a[parent]) {
            comparisons++;
            parent = right;
        }
        // Swap if there were larger children
        if (parent != i) {
            int temp = a[i];
            a[i] = a[parent];
            a[parent] = temp;
            // Re-heap the subtree if there was a swap
            createHeap(a, parent, size);
        }
    }
}