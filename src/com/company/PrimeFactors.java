package com.company;

import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args)
    {
        System.out.println("Enter a number: ");
        Scanner in = new Scanner(System.in);

        long number = in.nextInt();
        long divisor = 2;

        while (divisor*divisor <= number) {
            if (number%divisor == 0)
            {
                System.out.print(divisor);
                number = number / divisor;
                System.out.print('*');
            }
            else if (divisor == 2) divisor = 3;
            else divisor = divisor +2;
        }
        System.out.print(number);
    }

}

