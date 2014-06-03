package com.hackbulgaria.corejava;

public class Problems2Factory {
    String OATH_TOKEN = "THIS IS MY DEAR PASSWORD";

    public static Problems2 createProblems2Instance() {
        return new Problems2Impl();
    }

    public static void main(String[] args) {
    	Problems2 module = createProblems2Instance();
    	boolean areAnagrams = module.areAnagrams("magica", "gimaac");
    	int ocurrences = module.countOcurrences("sos", "Some sos textsos hesososre");
    	System.out.println(areAnagrams);
    	System.out.println(ocurrences);
 
    	int number = module.getOddOccurrence(new int[]{3, 4, 5, 5, 4, 3, 6});
    	System.out.println(number);
    	
    	int maxSpan = module.maxSpan(new int[]{1, 2, 1, 1, 3});
    	System.out.println(maxSpan);
    	
    	System.out.println(module.canBalance(new int[]{1, 1, 1, 2, 1}));
    	System.out.println(module.reverseMe("Spiderman"));
    	System.out.println(module.reverseEveryWord("What is this"));
    }

    public static void meh(Integer k) {
    }
}
