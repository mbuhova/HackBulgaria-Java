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
    	System.out.print(areAnagrams);
    	System.out.print(ocurrences);
    }

    public static void meh(Integer k) {
    }
}
