package ds.stack;

public class Main {

    public static void main(String[] args) {


        System.out.println(reverseString("abcdefghijklmnopqrstuvwxyz"));

    }

    public static String reverseString(String str){
        int stackSize = str.length();

        Stack tempStack = new Stack(stackSize);

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            tempStack.push(ch);
        }

        String result = "";
        while(!tempStack.isEmpty()){
            char ch = tempStack.pop();
            result += ch;
        }
        return result;
    }
}
