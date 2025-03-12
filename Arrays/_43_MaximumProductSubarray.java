/*
LeetCode - 152. Maximum Product Subarray
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer
Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

import java.util.Scanner;

public class _43_MaximumProductSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(getMaximumProductSubarray(arr, n));
        in.close();
    }
    private static int getMaximumProductSubarray(int[] arr, int n) {
        int prefixProdect = 1;
        int suffixProduct = 1;
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(prefixProdect == 0) prefixProdect = 1;
            if(suffixProduct == 0) suffixProduct = 1;
            prefixProdect = prefixProdect * arr[i];
            suffixProduct = suffixProduct * arr[n-i-1];
            maxProduct = max(maxProduct, max(prefixProdect, suffixProduct));
        }
        return maxProduct;
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }
}
