package com.company;

public class Numbers {
    public static class NWD {
        private long a, b, x, y;
        private long nwd;
        public NWD(long a, long b) {
            this.x = 0;
            this.y = 1;
            this.a = a;
            this.b = b;
            this.nwd = nwd();
        }
        private long nwd() {
            long temp, lastx = 1, lasty = 0, result, a1= a, b1 = b;
            while (b1 != 0)
            {
                long q = a1 / b1;
                long r = a1 % b1;
                a1 = b1;
                b1 = r;
                temp = x;
                x = lastx - q * x;
                lastx = temp;

                temp = y;
                y = lasty - q * y;
                lasty = temp;
            }
            x = lastx;
            y = lasty;
            result = (a * x) + (b * y);
            return result;
        }
        public long getA(){
            return a;
        }
        public long getB() {
            return b;
        }
        public long getX() {
            return x;
        }
        public long getY() {
            return y;
        }
        public long getNwd() {
            return nwd;
        }

    }
    public long mmi(long a, long n) {
        System.out.println("1. Obliczamy NWD dla a i n");
        NWD nwd = new NWD(a, n);
        System.out.println("NWD(" + a + ", " +  n + ") = " + nwd.getNwd());
        System.out.println("Parametry nwd: \n x = " + nwd.getX() + "\n y = " + nwd.getY());
        System.out.println("2. Sprawdzamy czy NWD != 1: " + (nwd.getNwd()!=1));
        if (nwd.getNwd() != 1) {
            System.out.println("Odwrotnosc modulo dla danych liczb nie istnieje!");
            return 0;
        } else {
            long result = (nwd.getX() % n + n) % n;
            System.out.println("3. Obliczamy wynik: \n (x mod m + m) mod m");
            return result;
        }

    }
    public long euler(long n) {
        long numberOfPrimeNumbers = 1;
        for (long i = 2; i < n; i++) {
            NWD nwd = new NWD(i, n);
            if (nwd.getNwd() == 1)
                numberOfPrimeNumbers++;
        }
        return numberOfPrimeNumbers;
    }


}
