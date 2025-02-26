/*
Given an integer N, check whether it is prime or not. A prime number is a number that is only divisible by 1 and 
itself and the total number of divisors is 2.
*/

import java.util.Scanner;

public class _07_CheckIfPrime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(isPrime(n) == true) {
            System.out.println(n + " is Prime number");
        }
        else {
            System.out.println(n + " is Not Prime number");
        }
        in.close();
    }

    private static boolean isPrime(int n) {
        int count = 0;
        for(int i=1; i*i<=n; i++) {
            if(n % i == 0) {
                count += 1;
                if(n/i != i) {
                    count += 1;
                }
            }
        }
        return count == 2;
    }
}
