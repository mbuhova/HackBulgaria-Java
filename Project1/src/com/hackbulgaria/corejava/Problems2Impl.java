package com.hackbulgaria.corejava;

import java.awt.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import javax.activity.InvalidActivityException;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
        int module = number % 2;
        return (module == 1 || module == -1);
    }

    @Override
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        
        double sqrt = Math.sqrt((double)number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int min(int... array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("There is no min element in empty collection");
        }
        int min = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public int kthMin(int k, int[] array) {
        if (array == null || array.length < k) {
            throw new RuntimeException("There is no min element in empty collection");
        }
        
        Arrays.sort(array);
        return array[k - 1];
    }

    @Override
    public float getAverage(int[] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException();
        }
        
        int sum = 0;
        
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        
        return ((float)sum / array.length);
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        if (upperBound == 2) {
            return 2;
        }
        
        return leastCommonMultiple(upperBound, getSmallestMultiple(upperBound - 1));
    }
    
    private static long leastCommonMultiple(long num1, long num2) {
        long lcm = (num1 * num2) /  gcd ( num1, num2 );
        return lcm;
    }
    
    private static long gcd(long k, long m) {
        while (k != m) {
           if (k > m) { 
               k = k-m; 
           } else  { 
               m = m-k; 
           }
        }
        return k;
     }

    @Override
    public long getLargestPalindrome(long N) {
        StringBuilder number = new StringBuilder(String.valueOf(N));
        int length = number.length();
        if (number.charAt(0) == '1' && number.charAt(length - 1) == '0') {
            long result = 9;
            for (int i = 1; i < length - 1; i++) {
                result += 9 * Math.pow(10, i);
            }
            return result;
        }
        
        for (int i = 0; i < length/2; i++) {
            if (number.charAt(i) < number.charAt(length - i - 1)) {
                number.setCharAt(length - i - 1, number.charAt(i));
            } 
            else if(number.charAt(i) > number.charAt(length - i - 1)){
                char prevChar = (char)((int)(number.charAt(i)) - 1);
                number.setCharAt(i, prevChar);
                number.setCharAt(length - i - 1, prevChar);
            }
        }
        
        return Long.parseLong(number.toString());
    }

    @Override
    public int[] histogram(short[][] image) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long doubleFac(int n) {
        long factorial = 1;
        long doubleFactorial = 1;
        
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        
        doubleFactorial = factorial;
        for (int i = n + 1; i <= factorial; i++) {
            doubleFactorial *= i;
        }
        return doubleFactorial;
    }

    @Override
    public long kthFac(int k, int n) {
        long begin = 1;
        long end = n;
        long currentFactorial = 1;
        
        for (int i = 0; i < k; i++) {
            for (long j = begin; j <= end; j++) {
                currentFactorial *= j;
            }
            begin = end + 1;
            end = currentFactorial;
        }
        
        return currentFactorial;
    }

    @Override
    public int getOddOccurrence(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        
        if (array.length == 0) {
            throw new ArithmeticException("Cannot find number in empty collection");
        }
        int[] copy = array.clone();
        Arrays.sort(copy);
        int counter = 1;
        int current = copy[0];
        
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] == current) {
                counter++;
            }
            else {
                if (counter % 2 == 1) {
                    return current;
                }
                current = copy[i];
                counter = 1;
            }
        }
        return current;
    }

    @Override
    public long pow(int a, int b) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        
        if (a.length != b.length) {
            throw new ArithmeticException();
        }
        
        int[] copyA = a.clone();
        int[] copyB = b.clone();
        Arrays.sort(copyA);
        Arrays.sort(copyB);
        long result = 0;
        
        for (int i = 0; i < copyB.length; i++) {
            result += (copyA[i] * copyB[i]);
        }
        return result;
    }

    @Override
    public int maxSpan(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        
        if (array.length == 0) {
            throw new ArithmeticException(
                    "Cannot find span between elements in an empty collection");
        }
        int maxSpan = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j >= i; j--) {
                if (array[i] == array[j]) {
                    int span = j - i + 1;
                    if (span > maxSpan) {
                        maxSpan = span;
                    }
                }
            }
        }
        return maxSpan;
    }

    @Override
    public boolean canBalance(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        
        if (array.length == 0) {
            throw new ArithmeticException(
                    "Cannot ficheck balance in an empty collection");
        }
        
        long leftSideSum = 0;
        long rightSideSum = 0;
        
        for (int i = 0; i < array.length; i++) {
            rightSideSum += array[i];
        }
        
        for (int i = 0; i < array.length; i++) {
            leftSideSum += array[i];
            rightSideSum -= array[i];
            if (leftSideSum == rightSideSum) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String reverseMe(String argument) {
        if (argument == null) {
            throw new NullPointerException();
        }
        
        StringBuilder result = new StringBuilder(argument.length());
        
        for (int i = argument.length() - 1; i >= 0; i--) {
            result.append(argument.charAt(i));
        }
        return result.toString();
    }

    @Override
    public String copyEveryChar(String input, int k) {
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < input.length(); i++) {
            for(int j = 0; j < k; j++) {
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }

    @Override
    public String reverseEveryWord(String arg) {
        if (arg == null) {
            throw  new NullPointerException();
        }
        String[] words = arg.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            result.append(reverseMe(words[i]) + " ");
        }
        result = result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    @Override
    public boolean isPalindrome(String argument) {
        String reversed = this.reverseMe(argument);
        if(reversed.equals(argument)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPalindrome(int number) {
        Integer num = new Integer(number);
        String argument = num.toString();
        String reversed = this.reverseMe(argument);
        if(reversed.equals(argument)) {
            return true;
        }
        return false;
    }

    @Override
    public int getPalindromeLength(String input) {
        String[] parts = input.split("[*]");
        int length = 0;
        
        if(parts.length != 2){
            return length;
        }
        
        for(int i = parts[0].length() - 1, j = 0; i >= 0 && j < parts[1].length(); i--, j++){
            if(parts[0].charAt(i) == parts[1].charAt(j)) {
                length++;
            }
            else{
                return length;
            }
        }
        return length;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
    	if(needle == null || haystack == null) {
    		throw new NullPointerException();
    	}
    	
    	if(needle.length() == 0 || needle.length() > haystack.length()) {
    		return 0;
    	}
    	
    	int counter = 0;
    	boolean isFoundOcurrence;
    	
    	for (int i = 0; i <= haystack.length() - needle.length(); i++) {
    		isFoundOcurrence = true;
			for(int j = 0; j < needle.length(); j++) {
				if(needle.charAt(j) != haystack.charAt(j + i)) {
					isFoundOcurrence = false;
					break;
				}
			}
			if(isFoundOcurrence) {
				counter++;
				i += needle.length() - 1;
			}
		}
    	return counter;
    }

    @Override
    public String decodeURL(String input) {
        return input.replace("%20", " ").replace("%3A", ":").
                replace("%3D", "?").replace("%2F", "/");
    }

    @Override
    public int sumOfNumbers(String input) {
        int sum = 0;
        StringBuilder number = new StringBuilder();
        
        for(int i = 0; i < input.length(); i++){
            if(Character.isDigit(input.charAt(i))){
                if(i > 0 && input.charAt(i - 1) == '-'){
                    number.append('-');
                }
                number.append(input.charAt(i));
            }
            else {
                if(number.length() > 0){
                    int currentNumber = Integer.parseInt(number.toString());
                    sum += currentNumber;
                    number.setLength(0);
                }            
            }
        }
        
        if(number.length() > 0) {
            int currentNumber = Integer.parseInt(number.toString());
            sum += currentNumber;
        }
        
        return sum;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
    	if(A == null || B == null) {
    		throw new NullPointerException();
    	}
    	
    	if(A.length() != B.length()) {
    		return false;
    	}
    	
        boolean[] visited = new boolean[A.length()];
        
        for(int i = 0; i < A.length(); i++) {
        	for(int j = 0; j < B.length(); j++) {
        		if(A.charAt(i) == B.charAt(j) && !visited[j]) {
        			visited[j] = true;
        			break;
        		}
        	}
        }
        
        for(int i = 0; i < visited.length; i++) {
        	if(!visited[i]) {
        		return false;
        	}
        }
        return true;
    }
    
    //Recursive method for finding anagrams count
    public int findCombinations(int index, String word, StringBuilder result, boolean[] visited, int counter) {
    	if(result.length() == word.length()) {
    		if(word.equals(result.toString())) {
    			counter++;
    		}
    		return counter;
    	}
    	
    	for(int i = 0; i < word.length(); i++) {
    		if(!visited[i]) {
    			result.append(word.charAt(i));
    			visited[i] = true;
    			findCombinations(index + 1, word, result, visited, counter);
    			visited[i] = false;
    			result.deleteCharAt(result.length() - 1);
    		}
    	}
    	return counter;
    }

    @Override
    public boolean hasAnagramOf(String a, String b) {      
        if(a.length() > b.length()){
            return false; 
        }
        
        for(int i = 0; i <= b.length() - a.length(); i++){
            String current = b.substring(i, a.length() + i);
            if(this.areAnagrams(a, current)){
                return true;
            }
        }
        return false;
    }

}
