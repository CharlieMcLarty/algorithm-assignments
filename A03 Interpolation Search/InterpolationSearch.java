// Name: Charlie McLarty
// Class: CS 4306/01
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 3
// IDE: Intellij

public class InterpolationSearch {
    boolean found;
    int index;
    int numDivisions;

    public InterpolationSearch(int[] values, int key){
        found = false;
        index = -1;
        numDivisions = 0; //For initial comparison above
        int highIndex = values.length - 1;
        int lowIndex = 0;
        //Makes sure key is in the range of numbers in values
        while (!found && key >= values[lowIndex] && key <= values[highIndex]){
            numDivisions++;
            //Finds division point
            index = lowIndex + ((key - values[lowIndex]) * (highIndex - lowIndex) / (values[highIndex] - values[lowIndex]));

            //If value is not found, cut list in half depending on whether key is larger or smaller than mid-value
            if (values[index] == key){
                found = true;
            }else if (key > values[index]){
                lowIndex = index + 1;
            }else{
                highIndex = index - 1;
            }
        }
        //Sets index back to -1 if key not in array
        if (!found){
            index = -1;
        }
    }
}
