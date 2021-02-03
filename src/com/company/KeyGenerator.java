package com.company;

//import javafx.util.Pair;

import java.util.Random;

public class KeyGenerator {
    private MyPublicKey publicKey;
    private MyPrivateKey privateKey;
    private long p, q, n, e, fn, d;
    public KeyGenerator() throws NoSuchInverseException {
        this.p = generateRandomPrime();
        System.out.println("Losowo wybrana liczba p: " + p);
        this.q = generateRandomPrime();
        System.out.println("Losowo wybrana liczba q: " + q);
        this.n = p * q;
        System.out.println("n = p*q = " + n);
        this.fn = (p -1)*(q - 1);
        System.out.println("fn = (p-1)*(q-1) = " + fn);
        this.e = generateE();
        System.out.println("e to losowo wybrana liczba miedzy 1 a fn (" + fn +")");
        System.out.println("1 < " + e + " < " + fn);
        this.d = generateD();
        System.out.println("d to odwrotnosc modularna liczby e, ktora jest podzielna przez fn");
        System.out.println("d = " + d);
        this.publicKey = new MyPublicKey(n, e);
        this.privateKey = new MyPrivateKey(n, d);
    }
    private long generateD() throws NoSuchInverseException {
        Numbers numbers = new Numbers();
        return numbers.mmi(e, fn);
    }
    private long generateE() {
        long e;

        while (true) {
            e = (long) (Math.random() * (fn - 1)) + 1;
            Numbers.NWD nwd = new Numbers.NWD(e, fn);

            if (e > 0 && nwd.getNwd() == 1)
                break;
        }

        return e;
    }
    private long generateRandomPrime() {
        FermatTest fermatTest = new FermatTest();
        Random ran = new Random();
        long randomNumber = ran.nextInt(2000099990);
        while (!fermatTest.isPrime(randomNumber)) {
            randomNumber = ran.nextInt(2000099990) + 1;
        }
        return randomNumber;
    }

    public MyPublicKey getPublicKey() {
        return publicKey;
    }

    public MyPrivateKey getPrivateKey() {
        return privateKey;
    }
}
