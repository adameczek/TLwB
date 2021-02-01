package com.company;

class Eratosfen {
    public static void main(String args[]) {
        int i, j;
        boolean isprime;
        for(i=1999900000; i < 2000099990; i++) {
            isprime = true;
            // sprawdza czy liczba ma resztę po dzielieniu
            for (j=2; j <= i/j; j++)
                // czy liczba jest liczbą pierwszą
                if((i%j) == 0) isprime = false;
            if (isprime)
                System.out.println(i + " - Simple Number");
        }
    }
}
