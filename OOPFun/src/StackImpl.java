import java.util.HashSet;


public class StackImpl implements Stack{
    private String[] stack;
    private int length;
    private HashSet<String> elements;
    
    public StackImpl(){
        this(4);
    }
    
    public StackImpl(int size){
        if(size < 0){
            throw new RuntimeException("The size of the stack should ne non negative number");
        }
        this.stack = new String[size];
        this.length = 0;
        this.elements = new HashSet<>();
    }
        
    @Override
    public void push(String item) {
        if(this.elements.contains(item)){
            throw new RuntimeException(String.format("The item %s already exists.", item));
        }
        
        if(this.length > this.stack.length){
            this.doubleCapacity();
        }
        
        this.elements.add(item);
        this.stack[this.length] = item;
        this.length++;
    }

    private void doubleCapacity() {
        String[] oldStack = this.stack;
        this.stack = new String[this.length * 2];
        System.arraycopy(oldStack, 0, this.stack, 0, this.length);
    }

    @Override
    public String pop() {
        if (this.length <= 0){
            throw new RuntimeException("Cannot remove element from an empty stack.");
        }
        
        String item = this.stack[this.length - 1];
        this.elements.remove(item);
        this.stack[this.length - 1] = null;
        this.length--;  
        return item;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public void clear() {
        this.length = 0;
        this.stack = new String[4];
        this.elements.clear();
    }
    
}
