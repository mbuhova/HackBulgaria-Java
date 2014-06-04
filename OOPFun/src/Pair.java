
public class Pair {
    private Object first;
    private Object second;
    
    public Pair(Object first, Object second){
        this.first = first;
        this.second = second;
    }
    
    public Object getFirst(){
        return this.first;
    }
    
    public void setFirst(Object value){
        this.first = value;
    }
    
    public Object getSecond(){
        return this.second;
    }
    
    public void setScond(Object value){
        this.second = value;
    }
    
    @Override
    public String toString(){
        return "[First: " + this.first.toString() + "; Second: " + this.second.toString() + "]";
    }
    
    public boolean equals(Pair other){
        return this.first.equals(other.first) && this.second.equals(other.second);
    }
}
