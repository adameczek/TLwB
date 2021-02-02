package com.company;

class Eratosfen {
    public static void main(String args[]) {
        int i, j;
        boolean isPrime;
        for(i=1999900000; i < 2000099990; i++) {
            isPrime = true;
            // sprawdza czy liczba ma resztę po dzielieniu
            for (j=2; j <= i/j; j++)
                // czy liczba jest liczbą pierwszą
                if((i%j) == 0) isPrime = false;
            if (isPrime)
                System.out.println(i + " - Simple Number");
        }
    }
}
