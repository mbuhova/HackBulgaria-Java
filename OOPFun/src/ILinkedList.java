
public interface ILinkedList {
    
    int size();
    
    int get(int index);
    
    int getFirst();
    
    int getLast();
    
    void addAt(int item, int index);
    
    void addFirst(int item);
    
    void addLast(int item);
    
    int removeAt(int index);
    
    int removeFirst();
    
    int removeLast();
}
