import java.util.HashSet;

public class StackImpl2{

    private MyLinkedList stack;
    private int length;
    private HashSet<Integer> elements;
    
    public StackImpl2(){
        this.stack = new MyLinkedList();
        this.length = 0;
        this.elements = new HashSet<>();
    }

    public void push(int item) {
        if(this.elements.contains(item)){
            throw new RuntimeException(String.format("The item %s already exists.", item));
        }
        
        this.stack.addLast(item);
        this.elements.add(item);
        this.length++;
    }

    public int pop() {
        int value = this.stack.getLast();
        this.stack.removeLast();
        this.length--;
        return value;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int length() {
        return this.length;
    }

    public void clear() {
        this.length = 0;
        this.stack = new MyLinkedList();
        this.elements.clear();
    }
}
