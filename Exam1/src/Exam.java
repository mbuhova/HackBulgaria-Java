import java.util.ArrayList;
import java.util.List;
import javax.management.RuntimeErrorException;


public class Exam {

    public static void main(String[] args) {
        Logger a = new Logger();
        a.log(2, "aa");
        a.log(4, "aa");
        a.setLevel(5);
        a.log(4, "aa");
        
        DateLogger b = new DateLogger();
        b.log(322, "Sha lq lq");
        b.setLevel(2);
        b.log(322, "Sha lq lq");
        b.log("aaa");
        b.log(1, "aaa");
    }
    
    public static List<Integer> sort(List<Integer> list){
        if(list == null){
            throw new RuntimeException("Null collection");
        }
        List<Integer> result = new ArrayList<>(list);
        quickSort(result, 0, result.size());
        return result;
    }

    private static void quickSort(List<Integer> result, int startIndex, int lastIndex) {
        if (startIndex == lastIndex - 1 || startIndex == lastIndex) {
            return;
        }
        
       int pivotIndex = startIndex;
       for (int i = pivotIndex; i < lastIndex; i++) {
           if(result.get(i) < result.get(pivotIndex)){             
               int pivotNext = result.get(pivotIndex + 1);
               int pivot = result.get(pivotIndex);
               result.set(pivotIndex, result.get(i));
               result.set(pivotIndex + 1, pivot);              
               if(i - 1 > pivotIndex){
                   result.set(i, pivotNext);
               }             
               pivotIndex++;
           }
       }
       
       quickSort(result, startIndex, pivotIndex);
       quickSort(result, pivotIndex + 1, lastIndex);
    }   
    
    public static List<Integer> reverse(List<Integer> list){
        if(list == null){
            throw new RuntimeException("Null collection");
        }
        List<Integer> result = new ArrayList<>();
        
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

    public static boolean isMonotonous(List<Integer> list){
        if(list.size() < 2){
            return true;
        }
        
        int element = list.get(0);
        
        if(element + 1 == list.get(1) || element == list.get(1)){
            for (int i = 1; i < list.size(); i++) {
                if(element + 1 != list.get(i) && element != list.get(i)){
                    return false;
                }
                element = list.get(i);
            }
            return true;
        }
        else if(element - 1 == list.get(1) || element == list.get(1)){
            for (int i = 1; i < list.size(); i++) {
                if(element - 1 != list.get(i) && element != list.get(i)){
                    return false;
                }
                element = list.get(i);
            }
            return true;
        }     
        return false;
    }
}
