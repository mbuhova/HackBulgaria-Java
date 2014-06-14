
public class Logger {
    protected static final int INIT_LEVEL = 3;
    protected int level;
    
    public Logger(){
        this(Logger.INIT_LEVEL);
    }
    
    public Logger(int level){
        this.setLevel(level);
    }
    
    public void setLevel(int level){
        if(level <= 0){
            throw new RuntimeException("Level should be a positive number.");
        }
        this.level = level;
    }
    
    public void log(int level, String message){
        if(level <= 0){
            throw new RuntimeException("Invalid level value. Level should be a positive number.");
        }
        
        if(level <= this.level){
            System.out.println(level + " => " + message);
        }
    }
    
    public void log(String message){
        this.log(Logger.INIT_LEVEL, message);
    }
}
