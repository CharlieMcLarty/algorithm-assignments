// Name:Charlie McLarty
// Class: CS 4306/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Intellij
//*****************************
/*
Algorithm Design Block

Algorithm Title: Find all matching values in two sorted lists

Logical Steps:

Step 1: Declare 2 arrays of sorted integers (any size) from user input and an empty list for matching values
Step 2: Create a pointer tracking the index for each list starting at 0 (m for list 1, n for list 2)
Step 3: Compare the values at each pointer
Step 4: If the values are the same, add the value at either pointer to the matching list,
otherwise, increment the pointer with the smaller value
Step 5: Compare values until the first pointer reaches the end of its list
Step 6: Print the 2 lists, matching values, and number of comparisons completed

Algorithm pseudocode syntax:

Algorithm: Find all matching values in two sorted lists
Input: Two Non-empty arrays (A) of sorted numbers (length m and n)
Output: Sorted list of matching numbers and the amount of comparisons

Begin
    L <- new List
    list1Index <- 0
    list2Index <- 0
    comparison <- 0
    while list1Index < m and list2Index < n
        comparisons++
        if list1[list1Index] = list2[list2Index]
            L add list1[list1Index]
            list1Index++
            list2Index++
        else if list1[list1Index] > list2[list2Index]
            list2Index++
        else list1Index++
End;
*****************************/

import java.util.ArrayList;
import java.util.Scanner;

public class CommonElements{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuOption = 0;
        int[] list1 = new int[0], list2 = new int[0];
        boolean listInitialized = false;
        while (menuOption != 3){
            System.out.print("""
                    -----------------MAIN MENU--------------
                    1. Read input lists (integer values)
                    2. Run algorithm and display output
                    3. Exit program
                    
                    Enter option number:\s""");
            menuOption = sc.nextInt();
            sc.nextLine();
            if (menuOption == 1){
                //Takes in string array and converts to int array for each list
                //Sets listInitialized to true to allow option 2 to run
                String[] rawList;
                System.out.print("\nEnter the sorted values for list1: ");
                rawList = sc.nextLine().split(" ");
                list1 = new int[rawList.length];
                for (int i = 0; i < rawList.length; i++){
                    list1[i] = Integer.parseInt(rawList[i]);
                }
                System.out.print("Enter the sorted values for list2: ");
                rawList = sc.nextLine().split(" ");
                list2 = new int[rawList.length];
                for (int i = 0; i < rawList.length; i++){
                    list2[i] = Integer.parseInt(rawList[i]);
                }
                System.out.print("\n");
                listInitialized = true;
            }else if (menuOption == 2){
                ArrayList<Integer> matchingValues = new ArrayList<>();
                //Start of algorithm
                if (listInitialized){
                    int list1Index = 0;
                    int list2Index = 0;
                    int comparisons = 0;
                    while (list1Index < list1.length && list2Index < list2.length){
                        comparisons++;
                        if (list1[list1Index] == list2[list2Index]){
                            matchingValues.add(list1[list1Index]);
                            list1Index++;
                            list2Index++;
                        }else if (list1[list1Index] > list2[list2Index]){
                            list2Index++;
                        }else{
                            list1Index++;
                        }
                    }
                    //End of algorithm
                    //Prints list contents, common values, and number of comparisons
                    System.out.print("\nList1:\t\t\t");
                    for (int i : list1){
                        System.out.print(i + " ");
                    }
                    System.out.print("\nList2:\t\t\t");
                    for (int i : list2){
                        System.out.print(i + "\s");
                    }
                    System.out.print("\nCommon Values:\t");
                    for (int i : matchingValues){
                        System.out.print(i + " ");
                    }
                    System.out.println("\nComparisons:\t" + comparisons + "\n");
                }else{
                    System.out.println("Please read input lists first\n");
                }
            }else if (menuOption != 3){
                System.out.println("Please select an option 1-3\n");
            }
        }
    }
}
