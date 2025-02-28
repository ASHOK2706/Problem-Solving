/*
Sieve Of Eratosthenes
*/
import java.util.Arrays;
import java.util.Scanner;

public class _10_SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] prime = getPrimeArray(n);
        printPrime1ToN(prime, n);
        in.close();
    }

    private static void printPrime1ToN(int[] prime, int n) {
        for(int i=2; i<=n; i++) {
            if(prime[i] == 1) System.out.print(i+" ");
        }
    }

    // Sieve Of Eratosthenes
    private static int[] getPrimeArray(int n) {
        int[] prime = new int[n + 1];
        Arrays.fill(prime, 1);

        for(int i=2; i*i<=n; i++) {
            if(prime[i] == 1) {
                for(int j=i*i; j<=n; j+=i) {
                    prime[j] = 0;
                }
            }
        }

        return prime;
    }
}


