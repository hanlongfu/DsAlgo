package ds.hashtable;

public class HashTableTest {

    public static void main(String[] args) {

        HashTable hashTable = new HashTable();

        hashTable.put("name", "John Smith");
        hashTable.put("weight", "80kg");
        hashTable.put("height", "177");
        hashTable.put("personality", "extroverted");

        System.out.println(hashTable.get("height"));


    }

}
