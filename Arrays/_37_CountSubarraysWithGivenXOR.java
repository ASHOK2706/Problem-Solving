/*
Given an array of integers ‘ARR’ and an integer ‘X’, you are supposed to find the number of subarrays of 'ARR' which 
have bitwise XOR of the elements equal to 'X'.

Sample Input 1 :
5 8
5 3 8 3 10
3 7
5 2 9
Sample Output 1 :
2
1
*/
import java.util.HashMap;
import java.util.Scanner;

public class _37_CountSubarraysWithGivenXOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();

        System.out.println(getCountSubarrayWithXOR(arr, n, k));
        in.close();
    }

    private static int getCountSubarrayWithXOR(int[] arr, int n, int k) {
        HashMap<Integer,Integer> preXorMap = new HashMap<>();
        int count = 0;
        int Xor = 0;
        int X = 0;
        preXorMap.put(Xor, 1);
        for(int i=0; i<n; i++) {
            Xor = Xor ^ arr[i];
            X = Xor ^ k;
            count += preXorMap.getOrDefault(X, 0);
            preXorMap.put(Xor, preXorMap.getOrDefault(Xor, 0) + 1);
        }
        return count;
    }
}
