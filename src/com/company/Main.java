package com.company;


import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchInverseException {
	// write your code here
        Numbers numbers = new Numbers();
        printBrake();
        System.out.println("1. Generowanie wszystkich liczb pierwszych z przedzialu: <1999900000, 2000099990>");
        printPrimes();
        printBrake();
        System.out.println("2. Sprawdzenie testem fermata czy podana liczba jest liczba pierwsza");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbe: ");
        long n = scanner.nextLong();
        if (FermatTest.isPrime(n, 5)) {
            System.out.println("Dana liczba jest liczba pierwsza");
        } else {
            System.out.println("Dana liczba nie jest liczba pierwsza");
        }

        printBrake();
        System.out.println("3. Rozbicie podanej liczby na czynniki pierwsze");
        System.out.print("Podaj liczbe: ");
        n = scanner.nextLong();
        System.out.println("Czynniki pierwsze tej liczby: ");
        numbers.primeFactorization(n);
        printBrake();
        System.out.println("4. Wyswietlenie funkcji eulera dla podanej liczby");
        System.out.print("Podaj liczbe: ");
        n = scanner.nextLong();
        System.out.print("Wartosc funkcji Eulera dla tej liczby: " + numbers.euler(n));
        printBrake();
        System.out.println("5. Wyswietlenie odwrotnosci modulo wprowadzonych liczb, uzywajac rozszerzonego algorytmu euklidesa");
        long a, b;
        System.out.print("Podaj pierwsza liczbe: ");
        a = scanner.nextLong();
        System.out.print("\n Podaj druga liczbe: ");
        b = scanner.nextLong();
        System.out.println("Odwrotnosc modulo=" + numbers.mmi(a, b));
        printBrake();
        //System.out.println("Euler= " + numbers.euler(7621));
        System.out.println("6. Wygenerowanie pary kluczy dla szyfru RSA");
        KeyGenerator keyGenerator = new KeyGenerator();
        System.out.println("Klucz publiczny: ");
        System.out.println("n = " + keyGenerator.getPublicKey().getN());
        System.out.println("e = " + keyGenerator.getPublicKey().getE());
        System.out.println("Klucz prywatny: ");
        System.out.println("n = " + keyGenerator.getPublicKey().getN());
        System.out.println("d = " + keyGenerator.getPrivateKey().getD());
        printBrake();

        System.out.println("6. Zaszyfrowanie wiadomosci (numer indeksu) kluczem publicznym");
        long m;
        long c;
        long decipher;
        System.out.print("Podaj numer indeksu do zaszyfrowania: ");
        m = scanner.nextLong();
        System.out.println("Wiadomosc przed szyfrowaniem: " + m);
        c = RSA.cipher(keyGenerator.getPublicKey(), m);
        System.out.println("Zaszyfrowana wiadomosc: " + c);
        printBrake();
        System.out.println("Odszyfrowanie wiadomości kluczem prywatnym");
        decipher = RSA.decipher(keyGenerator.getPrivateKey(), c);
        System.out.println("Odszyfrowana wiadomosc: " + decipher);
        printBrake();

    }
    private static void printBrake(){
        System.out.println("\n##############################################################################\n");
    }
    private static void printPrimes() {
        long min = 1999900000;
        long max = 2000099990;
        System.out.print("(");
        for (long i = min; i < max; i++) {
            if (FermatTest.isPrime(i, 3))
                System.out.print(i + ", ");
        }
        System.out.print(")\n");
    }
}
