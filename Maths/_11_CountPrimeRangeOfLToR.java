/*
Count Prime Numbers between L to R.
*/

import java.util.Scanner;

public class _11_CountPrimeRangeOfLToR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfQueries = in.nextInt();
        int[][] quries = new int[numberOfQueries][2];
        for(int i=0; i<numberOfQueries; i++) {
            quries[i][0] = in.nextInt();
            quries[i][1] = in.nextInt();
        }
        printPrimeCount(quries, numberOfQueries);
        in.close();
    }

    private static void printPrimeCount(int[][] quries, int numberOfQueries) {
        int[] prime = getSieveOfEratosthenes(1000000);
        countPrimesUsingSieve(prime);
        for(int i=0; i<numberOfQueries; i++) {
            int L = quries[i][0];
            int R = quries[i][1];
            int noOfPrime = prime[R] - prime[L - 1];
            System.out.println("Number Of Primnumber Between "+ L +" and "+ R +" : "+ noOfPrime);
        }
    }

    private static int[] getSieveOfEratosthenes(int n) {
        int[] prime = new int[n+1];
        for(int i=2; i<=n; i++) {
            prime[i] = 1;
        }
        for(int i=2; i*i<=n; i++) {
            if(prime[i] == 1) {
                for(int j=i*i; j<=n; j+=i) {
                    prime[j] = 0;
                }
            }
        }

        return prime;
    }

    private static void countPrimesUsingSieve(int[] prime) {
        int count = 0;
        for(int i=2; i<prime.length; i++) {
            count += prime[i];
            prime[i] = count;
        }
    }
}
