import java.util.Scanner;

public class _02_LongestSubArrayWithSumLessThanEqualK {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        int k = in.nextInt();
        System.out.println(findlonngestSubArray(arr, k));
        in.close();
    }

    private static int findlonngestSubArray(int[] arr, int k) {
        int n = arr.length;
        int left = 0; 
        int right = 0;
        int sum = 0;
        int maxLength = 0;
        while(right < n) {
            sum = sum + arr[right];
            if(sum > k) {
                sum = sum - arr[left];
                left++;
            }
            if(sum <= k) {
                int length = right - left + 1;
                if(length > maxLength) maxLength = length;
            }
            right++;
        }
        return maxLength;
    }
}
