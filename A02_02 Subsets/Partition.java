// Name:Charlie McLarty
// Class: CS 4306/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: Intellij
//*****************************
/*
Algorithm Design Block

Algorithm Title: Partition set into 2 subsets with same sum

Logical Steps:

Step 1: Find the total sum of the elements from the inputted list
Step 2: If odd, there is no possible subsets. Otherwise, continue if the sum is even
Step 3: Create two empty lists for the output (if there is a match)
Step 4: Find the target sum by dividing the original sum in half
Step 5: Create a list that will hold all possible subsets
Step 6: Make a loop that executes 2^n times where n is the number of elements (this is all the subset combinations)
Step 7: Make an inner loop j that also n times
Step 8: For each j iteration check if the jth bit of binary representation of i is 1 and add the jth element from the
original input into that subset.
Step 9: Add the subset made from the previous step to the subset list after the inner loop completes
Step 10: Loop through each subset checking if the subset sum is equal to the target sum. If there is no match then
there are no possible subsets
Step 11: If match is found, find the complement of the target subset by adding every value not in it to subset 2
Step 12: Print the two subsets if found the or that there were no found partitions

Algorithm pseudocode syntax:

Algorithm: Find all matching values in two sorted lists
Input: List A of size n
Output: 2 lists of elements with same sum (empty if there is none)

Begin
    sum <- 0
    for i <- 0 to n - 1 do
        sum = sum + A[i]
    if sum is even do
        targetSum <- sum / 2
        List S1 <- {}
        List S2 <- {}
        List SL <- {}
        numSubsets = 2^n

        for i <- 0 to numSubsets - 1 do
            List subset <- {}
            for j <- 0 to n - 1 do
                if jth bit of i is 1
                    subset add A[j]
            SL add subset

        for each subset in SL do
            subsetSum <- 0
            for each int l in subset do
                subsetSum = subsetSum + l
            if subsetSum == targetSum
                S1 = subset
                for m <- 0 to n - 1
                    if A[m] is not in S1
                        S2 add A[m]
            break

End;

Big-O Analysis:
This is assuming the sum is even or else avg performance would be drastically smaller
Table is split so it can fit
+-----------+---+-------------+----------------+---------------------+-------------------+---------------+
| sum = 0   | i | sum += A[i] | if sum is even | targetSum = sum / 2 | initialize 3 lists | numsets = 2^n |
+-----------+---+-------------+----------------+---------------------+-------------------+---------------+
| 1         | 1 | 1           | 1              | 1                   | 3                 | 1             |
+-----------+---+-------------+----------------+---------------------+-------------------+---------------+
|           | 2 | 1           |                |                     |                   |               |
+-----------+---+-------------+----------------+---------------------+-------------------+---------------+
|           | 3 | 1           |                |                     |                   |               |
+-----------+---+-------------+----------------+---------------------+-------------------+---------------+
|           | n | 1           |                |                     |                   |               |
+-----------+---+-------------+----------------+---------------------+-------------------+---------------+
| Totals: 1 |   | n           |  1             | 1                   |  3                |  1            |
+-----------+---+-------------+----------------+---------------------+-------------------+---------------+


+---------+----------+---+-------------+------------------+--------------------+
| i       | new List | j | if bit is 1 | subset add A[j]  | add Subset to List |
+---------+----------+---+-------------+------------------+--------------------+
| 1       | 1        | 1 | n           | BCS: 0 WCS: n    | 1                  |
+---------+----------+---+-------------+------------------+--------------------+
| 2       | 1        | 2 | n           | BCS: 0 WCS: n    | 1                  |
+---------+----------+---+-------------+------------------+--------------------+
| 3       | 1        | 3 | n           | BCS: 0 WCS: n    | 1                  |
+---------+----------+---+-------------+------------------+--------------------+
| 2^n     | 1        | n | n           | BCS: 0 WCS: n    | 1                  |
+---------+----------+---+-------------+------------------+--------------------+
| Totals: | 2^n      |   | 2^n*n       | BCS: 0 WCS 2^n*n | 2^n                |
+---------+----------+---+-------------+------------------+--------------------+

+---------+---------------+---+------------------+--------------------------+-----------------+-----+-------------------+---------------+
| i       | subsetSum = 0 | j | subsetSum + S[l] | if subsetSum = targetSum | S1 = subset     | m   | if A[m] not in S1 | S2 add A[m]   |
+---------+---------------+---+------------------+--------------------------+-----------------+-----+-------------------+---------------+
| 1       | 1             | 1 | 2^n              | 1                        | BCS: 0 WCS: 1   | 1   | 1                 | BCS: 0 WCS: 1 |
+---------+---------------+---+------------------+--------------------------+-----------------+-----+-------------------+---------------+
| 2       | 1             | 2 | 2^n              | 1                        | BCS: 0 WCS: 1   | 2   | 1                 | BCS: 0 WCS: 1 |
+---------+---------------+---+------------------+--------------------------+-----------------+-----+-------------------+---------------+
| 3       | 1             | 3 | 2^n              | 1                        | BCS: 0 WCS: 1   | 3   | 1                 | BCS: 0 WCS: 1 |
+---------+---------------+---+------------------+--------------------------+-----------------+-----+-------------------+---------------+
| 2^n     | 1             | k | 2^n              | 1                        | BCS: 0 WCS: 1   | 2^n | 1                 | BCS: 0 WCS: 1 |
+---------+---------------+---+------------------+--------------------------+-----------------+-----+-------------------+---------------+
| Totals: | 2^n           |   | k2^n             | 2^n                      | BCS: 0 WCS: 2^n |     | n                 | BCS: 0 WCS: n |
+---------+---------------+---+------------------+--------------------------+-----------------+-----+-------------------+---------------+
BCS: 4 + 2n + 16^n + 2^n*n + k2^n
WCS: 4 + 3n + 32^n + n^2*4^n + k2^n
AVG: (16^n+32^n+5n+2^n*n+k*2^(n+1)+n^2*4^n+8)/2
O(32^n)
*****************************/

import java.util.ArrayList;
import java.util.Scanner;

public class Partition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuChoice = 0;
        int[] elements = new int[0];
        boolean elementsInitialized = false;
        boolean subsetsFound = false;
        while (menuChoice != 4){
            System.out.print("""
                    -----------------MAIN MENU--------------
                    1. Read set size (number of integers)
                    2. Read set elements (integer value)
                    3. Run algorithm (display set size, set values, disjoint subsets)
                    4. Exit program
                    
                    Enter option number:\s""");
            menuChoice = sc.nextInt();
            if (menuChoice == 1){
               System.out.print("\nSelect the set size:\s");
               elements = new int[sc.nextInt()];
            }else if (menuChoice == 2){
                if (elements.length == 0){
                    System.out.println("Please select a set size first");
                }else{
                  for (int i = 1; i <= elements.length; i++){
                      System.out.print("\nEnter value\s" + i + ":\s");
                      elements[i - 1] = sc.nextInt();
                  }
                  elementsInitialized = true;
                }
            }else if (menuChoice == 3) {
                if (!elementsInitialized){
                    System.out.println("Please initialize list first");
                }else{
                    //Checks if sum of all digits
                    //If odd stop as there is no possible subsets
                    int sum = 0;
                    for (int i : elements){
                        sum += i;
                    }
                    //Used if subset combination is found
                    ArrayList<Integer> subset1 = new ArrayList<>();
                    ArrayList<Integer> subset2 = new ArrayList<>();
                    if (sum % 2 == 0){
                        //Subsets need to sum to half of total sum
                        int targetSum = sum / 2;
                        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
                        //Shift bit 1 to the left n times to give 2^n for n elements
                        int numSubsets = 1 << elements.length;
                        for (int i = 0; i < numSubsets; i++){
                            ArrayList<Integer> subset = new ArrayList<>();
                            for (int j = 0; j < elements.length; j++){
                                //Generate all bit combinations
                                //Checks the jth bit of binary representation of i is 1
                                //ex: if i = 5 (or 101) then elements[0] and elements[2] will be added
                                if ((i & (1 << j)) > 0) {
                                    subset.add(elements[j]);
                                }
                            }
                            subsets.add(subset);
                        }
                        //Loops through every subset checking if the total sum is
                        //equal to the target sum (half the sum of the original set)
                        for (ArrayList<Integer> subset: subsets){
                            int subsetSum = 0;
                            for (int number : subset){
                                subsetSum += number;
                            }
                            //If there is a match, then the second subset is found using the complement of the first subset
                            //Putting all elements that are not in subset 1 into subset 2
                            if (subsetSum == targetSum){
                                subset1 = subset;
                                for (int element : elements) {
                                    if (!subset1.contains(element)) {
                                        subset2.add(element);
                                    }
                                }
                                //Boolean used for printing purposes
                                subsetsFound = true;
                                break;
                            }
                        }
                    }
                    //Prints results
                    System.out.println("\nSet size:\t\t\t\t" + elements.length + "\sintegers");
                    System.out.print("Integer values:\t\t\t");
                    for (int i : elements){
                        System.out.print(i + "\s");
                    }
                    System.out.print("\nDisjoint subsets with same sum:\t");
                    if (subsetsFound){
                        System.out.println(subset1 + "\n\t\t\t\t\t\t\t\t" + subset2);
                    }else{
                        System.out.println("No disjoint subsets with the same sum of their elements found");
                    }
                }
            }else if (menuChoice != 4){
                System.out.print("Please select an option 1-4");
            }
            System.out.print("\n");
        }
    }

}
