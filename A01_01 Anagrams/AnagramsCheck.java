// Name:Charlie McLarty
// Class: CS 4306/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: Intellij
//*****************************
/*
Algorithm Design Block

Algorithm Title: Check if two strings are anagrams

Logical Steps:

Step 1: Declare 2 strings from user input
Step 2: Remove any spaces and capitalization from each string
Step 3: Convert each string into a char array
Step 4: Check if arrays are same length, if not, they are not anagrams. Otherwise, go to step 5
Step 5: For each char in the first string loop through each char in string2
Step 6: If there is a match set the char in string 2 to a space and set match to true and break inner loop
Step 7: If inner loop finishes completely without a match, the strings are not anagrams, break the outer loop

Algorithm pseudocode syntax:

Algorithm: Check if two strings are anagrams
Input: Two strings (m, n)
Output: Boolean for if they are anagrams and number of comparisons completed

Begin
    areAnagrams <- true
    comparisons <- 0
    for i <- 0 to n do
        isMatch = false
        for j <- 0 to n do
            comparisons++
            if m[i] == n[j]
                n[j] <- ' '
                isMatch = true
                break
        if not isMatch
            areAnagrams <- false
            break
    Print out isAnagrams
End;
*****************************/

import java.util.Scanner;

public class AnagramsCheck {
    public static void main(String[] args) {
        int menuOption = 0;
        Scanner sc = new Scanner(System.in);
        String string1 = "", string2 = "";
        boolean stringsInitialized = false;
        while (menuOption != 3){
            System.out.print("""
                    -----------------MAIN MENU--------------
                    1. Read input string1 and string2
                    2. Run algorithm and display output
                    3. Exit program
                    
                    Enter Option Number:\s""");
            menuOption = sc.nextInt();
            sc.nextLine();
            if (menuOption == 1){
                //Take in values for string1 and string2
                System.out.print("\nEnter string1: ");
                string1 = sc.nextLine();
                System.out.print("Enter string2: ");
                string2 = sc.nextLine();
                stringsInitialized = true;
                System.out.print("\n");
            }else if (menuOption == 2){
                boolean areAnagrams = true;
                int comparisons = 0;
                if (stringsInitialized){
                    //Remove spaces and capitalization
                    String string1NoSpace = string1.replaceAll(" ", "").toLowerCase();
                    String string2NoSpace = string2.replaceAll(" ", "").toLowerCase();
                    char[] stringArray1 = string1NoSpace.toCharArray();
                    char[] stringArray2 = string2NoSpace.toCharArray();
                    //Start of algorithm
                    if (stringArray1.length != stringArray2.length){
                       areAnagrams = false;
                    }else {
                        //Checks every char in string2 for each char in string1
                        //If 1 char loops through all of string2 without match they are not anagrams
                        //If there is a match the char in string2 is replaced with a space
                        for (int i = 0; i < stringArray1.length; i++) {
                            boolean isMatch = false;
                            for (int j = 0; j < stringArray2.length; j++) {
                                comparisons++;
                                //Removes character from second string if there is match
                                if (stringArray1[i] == stringArray2[j]) {
                                    stringArray2[j] = ' ';
                                    isMatch = true;
                                    break;
                                }
                            }
                            if (!isMatch) {
                                areAnagrams = false;
                                break;
                            }
                        }
                    }
                    //End of algorithm
                    //Print algorithm run details
                    System.out.print("\nString 1:\t\t" + string1 + "\nString 2:\t\t" + string2 + "\nOutput:\t\t\t");
                    if (areAnagrams){
                            System.out.println("Strings are anagrams");
                    }else{
                        System.out.println("Strings are not anagrams");
                    }
                    System.out.println("Comparisons:\t" + comparisons + "\n");
                }else {
                   System.out.println("Please read input for strings first\n");
                }
            }else if (menuOption != 3){
                System.out.println("\nPlease select an option 1-3\n");
            }
        }
    }
}
