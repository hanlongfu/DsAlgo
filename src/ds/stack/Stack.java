package ds.stack;

public class Stack {

    private int maxSize;
    private char[] stackArray;
    private int top;             //index position of the last item

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char j){
        if(isFull()){
            System.out.println("this stack is already full");
        } else {
            top++;                       //after addition, increase the index by one
            stackArray[top] = j;
        }
    }

    public char pop(){
        if(!isEmpty())
        {
            int old_top = top;
            top--;                       //after removal, decrease the index by one
            return stackArray[old_top];
        }
        System.out.println("the stack is already empty.");
        return '0';
    }

    public char peak(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top == -1);         //if empty, top is -1
    }

    public boolean isFull(){
        return (maxSize -1) == top;
    }

}
