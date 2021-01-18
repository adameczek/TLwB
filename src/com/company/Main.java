package com.company;

public class Main {

    public static void main(String[] args) throws NoSuchInverseException {
	// write your code here
        int x = 1, y = 1;
        Numbers numbers = new Numbers();
        //System.out.println("Euler= " + numbers.euler(7621));
        System.out.println("Odwrotnosc modulo=" + numbers.mmi(631, 11));
        System.out.println("test");
    }
}
