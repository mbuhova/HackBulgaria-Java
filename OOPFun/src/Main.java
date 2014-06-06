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
        
        MyLinkedList list = new MyLinkedList();
        list.addFirst(1);
        list.addLast(2);
        list.addFirst(0);
        list.addAt(12, 1);
        list.removeAt(1);
        list.removeAt(2);
        list.addAt(5, 0);
        System.out.println(list);
        System.out.println(list.size());
        
        StackImpl2 stack2 = new StackImpl2();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        System.out.println(stack2.length());
        System.out.println(stack2.pop());
        System.out.println(stack2.length());
    }

}
