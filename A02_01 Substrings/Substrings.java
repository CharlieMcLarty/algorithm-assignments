// Name:Charlie McLarty
// Class: CS 4306/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: Intellij
//*****************************
/*
Algorithm Design Block

Algorithm Title: Find all AB substrings in a string

Logical Steps:

Step 1: Create an int for comparisons, substrings, and # of A's and initialize them to 0
Step 2: Loop through the input string checking if the value is an 'A' or 'B' incrementing comparisons for each
Step 3: If value is 'A', increment the A count integer
Step 4: If value is 'B', add the A count to the number of substrings
Step 5: Print the input string, # of substrings, and # of comparisons

Algorithm pseudocode syntax:

Algorithm: Find all matching values in two sorted lists
Input: Two Non-empty arrays (A) of sorted numbers (length m and n)
Output: Sorted list of matching numbers and the amount of comparisons

Begin
    comparisons <- 0
    substrings <- 0
    aCount <- 0
    for i <- 0 to n - 1 do
        if input[i] = 'A'
            aCount++
        if input[i] = 'B'
            substrings = substrings + aCount
        comparisons = comparisons + 2
End;

Big-O Analysis:
+-----------+---------+---------+-------+---------------+---------------+---------------+---------------+---------------+
| comp = 0  | sub = 0 | A's = 0 | for i | if char = 'A' | A's++         | if char = 'B' | sub += A's    | comp += 2     |
+-----------+---------+---------+-------+---------------+---------------+---------------+---------------+---------------+
| 1         | 1       | 1       | 1     | 1             | BCS: 0 WCS: 1 | 1             | BCS: 0 WCS: 1 | BCS: 0 WCS: 1 |
+-----------+---------+---------+-------+---------------+---------------+---------------+---------------+---------------+
|           |         |         | 2     | 1             | BCS: 0 WCS: 1 | 1             | BCS: 0 WCS: 1 | BCS: 0 WCS: 1 |
+-----------+---------+---------+-------+---------------+---------------+---------------+---------------+---------------+
|           |         |         | 3     | 1             | BCS: 0 WCS: 1 | 1             | BCS: 0 WCS: 1 | BCS: 0 WCS: 1 |
+-----------+---------+---------+-------+---------------+---------------+---------------+---------------+---------------+
|           |         |         | n     | 1             | BCS: 0 WCS: 1 | 1             | BCS: 0 WCS: 1 | BCS: 0 WCS: 1 |
+-----------+---------+---------+-------+---------------+---------------+---------------+---------------+---------------+
| Totals: 1 | 1       | 1       |       | n             | BCS: 0 WCS: n | n             | BCS: 0 WCS: n | BCS: 0 WCS: n |
+-----------+---------+---------+-------+---------------+---------------+---------------+---------------+---------------+
BCS = 3 + 2n
WCS = 3 + 5n
Avg = 7n/2 + 3
O(n)
*****************************/

import java.util.Scanner;

public class Substrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuChoice = 0;
        String input = "";
        // Menu
        while (menuChoice != 3){
            System.out.print("""
                    -----------------MAIN MENU--------------
                    1. Read input string
                    2. Run algorithm (display input, number of substrings, number of comparisons)
                    3. Exit program
                    
                    Enter option number:\s""");
            menuChoice = sc.nextInt();
            sc.nextLine();
            //Initialize string input from user input, convert to uppercase for comparisons
            if (menuChoice == 1){
                System.out.print("\nEnter input string:\s");
                input = sc.nextLine().toUpperCase();
            }else if (menuChoice == 2){
                //Checks if string was initialized
                if (!input.equals("")){
                    int substrings = 0;
                    int aCount = 0;
                    int comparisons = 0;
                    //Check if char is A or B
                    //Increment A count if value is a
                    //Add A count to substrings if value is B (each A that comes before that B)
                    for (int i = 0; i < input.length(); i++){
                        if (input.charAt(i) == 'A'){
                            aCount++;
                        }
                        if (input.charAt(i) == 'B'){
                            substrings += aCount;
                        }
                        comparisons += 2;
                    }
                    System.out.println("\nInput string:\t\t" + input
                            + "\n# of substrings:\t" + substrings
                            + "\n# of comparisons:\t" + comparisons);
                }else{
                    System.out.println("Please read an input string first\n");
                }
                //When user puts in option other than 1-3
            }else if (menuChoice != 3){
                System.out.println("Please select an option 1-3\n");
            }
            System.out.print("\n");
        }
    }
}
