
public class MyLinkedList implements ILinkedList{
    private Node first;
    private Node last;
    private int size;
    
    public MyLinkedList(){
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int get(int index) {
        int result = 0;
        
        if(index < 0 || index >= this.size){
            throw new RuntimeException("Index is outside the boundaries of the list.");            
        }
        else if(index == 0){
            result = this.first.getValue();
        }
        else if(index == this.size - 1){
            result = this.last.getValue();
        }
        else{
            int counter = 0;
            Node searched = null;
            while(counter <= index){
                if(searched == null){
                    searched = this.first;
                }
                else{
                    searched = searched.getNext();
                }
                counter++;
            }
            result = searched.getValue();
        }
        return result;
    }

    @Override
    public int getFirst() {
        if(this.size == 0){
            throw new RuntimeException("The list is empty.");
        }
        return this.first.getValue();
    }

    @Override
    public int getLast() {
        if(this.size == 0){
            throw new RuntimeException("The list is empty.");
        }
        return this.last.getValue();
    }

    @Override
    public void addAt(int item, int index) {
        if(index < 0 || index > this.size){
            throw new RuntimeException("Index is outside the boundaries of the list.");            
        }
        else if(index == 0){
            this.first.addBefore(item);
            this.first = this.first.getPrevious();
        }
        else if(index == this.size){
            this.last.addAfter(item);
            this.last = this.last.getNext();
        }
        else{
            int counter = 0;
            Node toAddAfter = null;
            while(counter < index){
                if(toAddAfter == null){
                    toAddAfter = this.first;
                }
                else{
                    toAddAfter = toAddAfter.getNext();
                }
                counter++;
            }
            toAddAfter.addAfter(item);
        }
        this.size++;
    }

    @Override
    public void addFirst(int item) {        
        if(this.size == 0){
            this.first = new Node(item, null, null);
            this.last = this.first;
        }
        else{
            this.first.addBefore(item);
            this.first = this.first.getPrevious();
        }
        this.size++;
    }

    @Override
    public void addLast(int item) {
        if(this.size == 0){
            this.last = new Node(item, null, null);
            this.first = this.last;
        }
        else{
            this.last.addAfter(item);
            this.last = this.last.getNext();
        }
        this.size++;
    }

    @Override
    public int removeAt(int index) {
        if(index < 0 || index >= this.size){
            throw new RuntimeException("Index is outside the boundaries of the list.");            
        }
        else if(index == 0){
            return this.removeFirst();
        }
        else if(index == this.size - 1){
            return this.removeLast();
        }
        else{
            int counter = 0;
            Node toRemove = null;
            while(counter <= index){
                if(toRemove == null){
                    toRemove = this.first;
                }
                else{
                    toRemove = toRemove.getNext();
                }
                counter++;
            }
            int value = toRemove.getValue();
            toRemove.remove();
            this.size--;
            return value;
        }
    }

    @Override
    public int removeFirst() {
        if(this.size <= 0){
            throw new RuntimeException("Cannot remove item from an empty list");
        }
        int toRemove = this.first.getValue();
        Node newFirst = this.first.getNext();
        this.first = null;
        this.first = newFirst;
        this.size--;
        return toRemove;
    }

    @Override
    public int removeLast() {
        if(this.size <= 0){
            throw new RuntimeException("Cannot remove item from an empty list");
        }
        int toRemove = this.last.getValue();
        Node newLast = this.last.getPrevious();
        this.last.remove();
        this.last = newLast;
        this.size--;
        return toRemove;
    }
    
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        if(this.first != null){
            Node current = this.first;
            while(current != null){
                result.append(current.getValue() + ", ");
                current = current.getNext();
            }
        }
        return result.toString();
    }
}
