
public class Node {
    private Node previous;
    private Node next;
    private int value;
    
    public Node(int value, Node prev, Node next){
        this.value = value;
        this.previous = prev;
        this.next = next;
    }
    
    public Node getPrevious(){
        return this.previous;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public void setValue(int number){
        this.value = number;
    }
    
    public void addAfter(int number){
        Node newNode = new Node(number, this, this.next);
        this.next.previous = newNode;
        this.next = newNode;
    }
    
    public void addBefore(int number){
        Node newNode = new Node(number, this.previous, this);
        
        if(this.previous != null){
            this.previous.next = newNode;
        }      
        this.previous = newNode;
    }
}
