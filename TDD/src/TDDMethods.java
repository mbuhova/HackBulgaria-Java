import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


public class TDDMethods {
    
    public long maxScalarSum(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            throw new RuntimeException("Invalid arrays.");
        }
        long result = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }
    
    public int getNumberOfDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int digits = 0;
        while (number != 0) {
            number /= 10;
            digits++;
        }
        return digits;
    }
    
    public String stichMeUp(Object glue, Object... tokens) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < tokens.length; i++) {
            if (i != tokens.length - 1) {
                result.append(tokens[i].toString() + glue);
            }
            else {
                result.append(tokens[i].toString());
            }
        }
        return result.toString();
    }
    
    public String reduceFilePath(String path){
        Stack<String> result = new Stack<>();
        String[] parts = path.split("/");     
        
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() != 0 && !parts[i].equals(".")) {
               if (parts[i].equals("..")) {
                   if (result.size() > 0) {
                       result.pop();
                   }                
               }
               else {
                   result.push("/" + parts[i]);
               }
            }
        }
        
        StringBuilder output = new StringBuilder();
        for (String item : result) {
            output.append(item);
        }
        if (output.length() == 0) {
            return "/";
        }
        return output.toString();
    }
}
