package ds.hashtable;

import jdk.swing.interop.SwingInterOpUtils;

public class HashTable {

    // hash table is an array of LinkedLists

    private int INITIAL_SIZE = 16;

    private HashEntry[] data;  //array of LinkedList

    //Each entry is a linkedlist
    class HashEntry{
        String key;
        String value;
        HashEntry next;

        public HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    //HashTable Constructor
    public HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }


    //insert an entry into HashTable
    public void put(String key, String value){

        //get the index
        int index = getIndex(key);

        //create the linkedlist entry
        HashEntry entry = new HashEntry(key, value);

        //if no entry there - add it
        if(data[index] == null) {
            data[index] = entry;
        //else handle collision by adding to end of linked list
        } else {
            HashEntry entries = data[index];

            //walk to the end
            while(entries.next != null){
                entries = entries.next;
            }

            //Add our new entry there
            entries.next = entry;

        }

    }

    //retrieve a value from hashtable
    public String get(String key){
        //get the index
        int index = getIndex(key);

        // get the current list of entries (at that index position)
        HashEntry entries = data[index];

        // if we have existing entries against  this key...
        if (entries != null){
            // else walk chain until find a match
            while (!entries.key.equals(key) && entries.next != null) {
                entries = entries.next;
            }

            //then return it
            return entries.value;

        }
        //if no entries against this key
        return null;
    }


    private int getIndex(String key){
        //get the hashcode

        int hashCode = key.hashCode();
        System.out.println("hashCode = " + hashCode);

        //convert to index
        //bitwise operation avoids negative index
        int index = (hashCode & 0x7fffffff ) % INITIAL_SIZE;

        System.out.println("index = " + index);

        //Hack to force collision for testing
        if (key.equals("John Smith") || key.equals("Sandra Dee")) {
            index = 4;
        }

        return index;

    }






}
