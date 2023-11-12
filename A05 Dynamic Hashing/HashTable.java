public class HashTable {
    public Node[] table;
    public int comparisons;

    public HashTable(){
        table = new Node[26];
        comparisons = 0;
    }

    public void hashWord(String word){
        int index = word.charAt(0) - 97;
        //Adds new node if list is empty
        if (table[index] == null){
            table[index] = new Node(word);
        }else{
            //Check first node of list
            if (table[index].word.equals(word)){
                table[index].occurrences++;
            }else{
                //Search rest of list for word
                Node temp = table[index];
                while (temp.next != null){
                    comparisons++;
                    temp = temp.next;
                    if (temp.word.equals(word)){
                        temp.occurrences++;
                        return;
                    }
                }
                //Add word to linked list if it wasn't found
                temp.next = new Node(word);
            }
        }
    }

    public void printNodes(){
        System.out.println("Key Word\tWord Count\n-----------------------");
        for (Node n : table){
            if (n != null) {
                System.out.printf("%-15s", n.word);
                System.out.println(n.occurrences);
                Node temp = n;
                while (temp.next != null) {
                    temp = temp.next;
                    System.out.printf("%-15s", temp.word);
                    System.out.println(temp.occurrences);
                }
            }
        }
    }

    private class Node{
        Node next;
        String word;
        int occurrences;

        public Node(String word){
            this.word = word;
            this.next = null;
            occurrences = 1;
        }
    }
}
