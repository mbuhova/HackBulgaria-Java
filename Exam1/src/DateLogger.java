import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateLogger extends Logger{
    private boolean printEverything;
    
    public DateLogger(){
        printEverything = true;
    }
    
    public DateLogger(int level){
        super(level);
    }
    
    @Override
    public void setLevel(int level){
        super.setLevel(level);
        this.printEverything = false;
    }
    
    @Override
    public void log(int level, String message){
        if(level <= 0){
            throw new RuntimeException("Invalid level value. Level should be a positive number.");
        }       
        
        if(printEverything || level <= this.level){
            DateFormat dateFormat = new SimpleDateFormat("| HH:mm:ss dd.MM.yyyy |");
            Date date = new Date();
            System.out.println(dateFormat.format(date) + " " + level + " => " + message);
        }
    }
    
    @Override
    public void log(String message){
        this.log(Logger.INIT_LEVEL, message);
    }
}
