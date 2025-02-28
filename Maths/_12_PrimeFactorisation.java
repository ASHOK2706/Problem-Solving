/*
You are given a positive number N. Using the concept of Sieve, compute its prime factorisation.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _12_PrimeFactorisation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int noOfQueries = in.nextInt();
        int[] queries = new int[noOfQueries];
        for(int i=0; i<noOfQueries; i++) {
            queries[i] = in.nextInt();
        }
        printPrimeFactors(queries, noOfQueries);
        in.close();
    }

    private static void printPrimeFactors(int[] queries, int noOfQueries) {
        int[] spf = implementSmallestPrimeFactorisation(1000000);
        for(int query : queries) {
            System.out.println("Prime Factors of "+query+" is : "+getPrimeFactorisation(spf, query));
        }
    }

    private static List<Integer> getPrimeFactorisation(int[] spf, int num) {
        List<Integer> primeFactros = new ArrayList<>(); 
        while(num != 1) {
            primeFactros.add(spf[num]);
            num = num / spf[num];
        }
        return primeFactros;
    }
    private static int[] implementSmallestPrimeFactorisation(int n) {
        int[] spf = new int[n+1];
        for(int i=2; i<=n; i++) {
            spf[i] = i;
        }

        for(int i=2; i*i<=n; i++) {
            if(spf[i] == i) {
                for(int j=i*i; j<=n; j+=i) {
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }
}
