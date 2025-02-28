/*
Given a number N. Find its unique prime factors in increasing order.
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class _08_PrintAllFactorsOfNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(getAllPrimeFactor(n));
        in.close();
    }

    private static List<Integer> getAllPrimeFactor(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        for(int i=2; i*i<=n; i++) {
            if(n % i == 0) {
                primeFactors.add(i);
                while(n % i ==0) {
                    n = n / i;
                }
            }
        }
        if (n != 1) primeFactors.add(n);
        return primeFactors;
    }
}
