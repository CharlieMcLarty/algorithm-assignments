import java.util.Scanner;

public class dynamicHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menuOption = 0;
        String text = "";
        String[] words = new String[0];
        HashTable hashTable = new HashTable();
        while (menuOption != 5){
            System.out.print("""
                    ---------------MAIN MENU---------------
                    1. Read input text
                    2. Hash Input Text to Hash Table
                    3. Display Words and Occurrences
                    4. Display Efficiency Outputs
                    5. Exit Program
                    
                    Enter option number:\s""");
            menuOption = sc.nextInt();
            if (menuOption == 1){
                sc.nextLine();
                System.out.print("\nEnter text:\s");
                text = sc.nextLine();
            }else if (menuOption == 2){
                if (!text.isBlank()){
                    text = text.toLowerCase();
                    words = text.split(" ");
                    for (String s : words){
                        hashTable.hashWord(s);
                    }
                }else{
                    System.out.println("\nPlease read input text first");
                }
            }else if (menuOption == 3){
                if (words.length != 0) {
                    hashTable.printNodes();
                }else{
                    System.out.println("\nPlease enter text and hash it first");
                }
            }else if (menuOption == 4){
                if (words.length != 0){
                    System.out.print("Input values:\s");
                    for (String s : words){
                        System.out.print(s + ",\s");
                    }
                    System.out.println("\nInputs size:\s" + words.length);
                    System.out.println("Number of comparisons:\s" +  hashTable.comparisons);
                }else{
                    System.out.println("\nPlease enter text and hash it first");
                }
            }else if (menuOption != 5){
                System.out.println("Please enter a values 1-5");
            }
            System.out.print("\n");
        }
    }
}
