public class Main {

    public static void main(String[] args) {
        Car car = new Car();
        Car audi = new Audi();
        BMW bmw = new BMW();
        Honda honda = new Honda();
        System.out.println(car);
        System.out.println(audi);
        System.out.println(bmw);
        System.out.println(honda);
        
        Time time = new Time(13, 3, 6, 12, 6, 2014);      
        System.out.println(time);
        
        Pair pairOne = new Pair("Java", "Core");
        Pair pairTwo = new Pair("Java", "Core");
        System.out.println(pairOne.equals(pairTwo));
        
        StackImpl stack = new StackImpl();
        stack.push("AAA");
        stack.push("BBB");
        stack.push("CCC");
        System.out.println(stack.length());
        System.out.println(stack.pop());
        System.out.println(stack.length());
    }

}
