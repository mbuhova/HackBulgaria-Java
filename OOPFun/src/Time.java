public class Time {
    private int hours;
    private int minutes;
    private int seconds;
    private int day;
    private int month;
    private int year;
    
    public Time(int hours, int minutes, int seconds, int day, int month, int year){
        if(hours < 0 || minutes < 0 || seconds < 0 || day < 0 || month < 0){
            throw new RuntimeException("The values should be a non negative numbers");
        }
        
        if(hours > 24 || minutes > 59 || seconds > 59 || day > 31 || month > 12 || year < 1000){
            throw new RuntimeException("Invalid values");
        }
        
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public int getHours(){
        return this.hours;
    }
    
    public int getMinutes(){
        return this.minutes;
    }
    
    public int getSeconds(){
        return this.seconds;
    }
    
    public int getDay(){
        return this.day;
    }
    
    public int getMonth(){
        return this.month;
    }
    
    public int getYear(){
        return this.year;
    }
    
    @Override
    public String toString(){
        String result = String.format("%02d:%02d:%02d %02d.%02d.", this.hours, this.minutes, this.seconds,
                this.day, this.month);
        result += this.year % 100;
        return result;
    }
    
}
