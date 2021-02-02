package com.company;


import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws NoSuchInverseException {
	// write your code here
        int x = 1, y = 1;
        Numbers numbers = new Numbers();
        //System.out.println("Euler= " + numbers.euler(7621));
        System.out.println("Odwrotnosc modulo=" + numbers.mmi(631, 11));
        System.out.println("test");
        KeyGenerator keyGenerator = new KeyGenerator();
        System.out.println("private key N: " + keyGenerator.getPrivateKey().getN());
        System.out.println("private key D: " + keyGenerator.getPrivateKey().getD());
        long m = 24450;
        long c;
        long decipher;
        System.out.println("Wiadomosc przed szyfrowaniem: " + m);
        c = RSA.cipher(keyGenerator.getPublicKey(), m);
        System.out.println("Zaszyfrowana wiadomosc: " + c);
        decipher = RSA.decipher(keyGenerator.getPrivateKey(), c);
        System.out.println("Odszyfrowana wiadomosc: " + decipher);

    }
}
