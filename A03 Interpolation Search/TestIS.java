// Name: Charlie McLarty
// Class: CS 4306/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 3
// IDE: Intellij

import java.util.Random;
import java.util.Scanner;

public class TestIS {
    static Random random = new Random();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuOption = 0;
        int[] values = {};
        int tableSize = 0;
        //User menu that loops unless user inputs 4
        while (menuOption != 4){
            System.out.print("""
                    ----------------------MAIN MENU-------------------
                    1. Create, populate, and display array Values[]
                    2. Read output table size
                    3. Run interpolation search and display outputs
                    4. Exit program

                    Enter option number:\s""");
            menuOption = sc.nextInt();
            if (menuOption == 1){
                //Generate values and prints them
                values = RandomDistinct();
                int rowCount = 0;
                for (int i : values){
                    rowCount++;
                    System.out.printf("%-5d", i);
                    //Goes to new line every 30 values
                    if (rowCount == 30){
                        System.out.print("\n");
                        rowCount = 0;
                    }
                }
                System.out.print("\n");
            }else if (menuOption == 2){
                System.out.print("Enter table size:\s");
                tableSize = sc.nextInt();
            }else if (menuOption == 3){
                //Runs search if values and table size were initialized
                if (values.length == 0 || tableSize == 0){
                    System.out.println("Please create array and set a table size");
                }else{
                    RunIS(values, tableSize);
                }
            }else if (menuOption != 4){
                System.out.print("Please input a value between 1-4");
            }
            System.out.print("\n");
        }
    }

    public static int[] RandomDistinct(){
        int[] values = new int[1024];
        //Brute force approach
        for (int i = 0; i < values.length; i++){
            int value = random.nextInt(9998) + 1;
            boolean distinct = true;
            //Check if value already exists in array
            for (int j = 0; j <= i; j++){
                if (value == values[j]){
                    //Loop will run additional time if it already exists
                    i--;
                    distinct = false;
                    break;
                }
            }
            //Adds to array if no duplicate values found
            if (distinct){
                values[i] = value;
            }
        }
        //Sorts list with selection sort
        for (int i = 0; i < values.length - 1; i++){
            int min = i;
            //Find minimum value and replaces at index i
            for (int j = i + 1; j < values.length; j++){
                if (values[j] < values[min]){
                    min = j;
                }
            }
            //Swap i and min
            int temp = values[i];
            values[i] = values[min];
            values[min] = temp;
        }
        return values;
    }

    public static void RunIS(int[] values, int size){
        System.out.println("\nKey\t\tFound\t\tIndex\t\tDivisions\n" +
                "-------------------------------------------");
        float divisionAverage = 0;
        //Generate random key in range and run IS on it for table size
        //Calculate average number of divisions and find difference with average 3.322
        for (int i = 0; i < size; i++){
            int key = random.nextInt(9998) + 1;
            InterpolationSearch IS = new InterpolationSearch(values, key);
            divisionAverage += IS.numDivisions;
            System.out.printf("%-5d", key);
            System.out.print("\t" + IS.found + "\t\t\s");
            System.out.printf("%-5d" + "\t\t\t", IS.index);
            System.out.printf("%-5d" + "\n", IS.numDivisions);
        }
        divisionAverage /= size;
        System.out.println("\nDivisions average:\t" + divisionAverage);
        System.out.println("Difference:\t\t\t" + (3.322 - divisionAverage));
    }
}
