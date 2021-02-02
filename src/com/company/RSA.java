package com.company;

import java.math.BigInteger;

public class RSA {
    public static long decipher(MyPrivateKey key, long c) {
        BigInteger bigC =  BigInteger.valueOf(c);
        BigInteger bigD = BigInteger.valueOf(key.getD());
        BigInteger bigN = BigInteger.valueOf(key.getN());
//        BigInteger pow = pow(bigC, bigD);
//        BigInteger pow = bigC.pow(bigD.intValue());

        BigInteger m = bigC.modPow(bigD, bigN);
        System.out.println("c^d = " + c + " ^ " + bigD.toString() + " =  " + m.toString());
        return m.longValue();
    }
    public static long cipher(MyPublicKey key, long m) {
        BigInteger bigM =  BigInteger.valueOf(m);
        BigInteger bigE = BigInteger.valueOf(key.getE());
        BigInteger bigN = BigInteger.valueOf(key.getN());
//        BigInteger pow = pow(bigM, bigE);
//        BigInteger pow = bigM.pow(bigE.intValue());
        BigInteger c = bigM.modPow(bigE, bigN);

        System.out.println("m^e = " + m + " ^ " + bigE.toString() + " =  " + c.toString());
        return c.longValue();
    }
    private static BigInteger pow(BigInteger base, BigInteger exponent) {
        BigInteger result = BigInteger.ONE;
        while (exponent.signum() > 0) {
            if (exponent.testBit(0)) result = result.multiply(base);
            base = base.multiply(base);
            exponent = exponent.shiftRight(1);
        }
        return result;
    }


}
