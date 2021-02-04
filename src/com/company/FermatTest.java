package com.company;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class FermatTest {
    public static boolean isPrime(long inputNum, int iterations)
    {
            if (inputNum == 0 || inputNum == 1)
                return false;
            if (inputNum == 2)
                return true;


            for (int i = 0; i < iterations; i++) {
                long random;

                while (true) {
                    random = 3 + (long) (Math.random() * ((inputNum - 2) - 3));
                    Numbers.NWD nwd = new Numbers.NWD(random, inputNum);
                    if (nwd.getNwd() == 1)
                        break;
                }
                BigInteger result = BigInteger.valueOf(random).modPow(BigInteger.valueOf(inputNum-1), BigInteger.valueOf(inputNum));
                if (!result.equals(BigInteger.ONE))
                    return false;
            }
            return true;
    }
}