/*
LeetCode - 875
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and 
will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from 
that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30
*/

import java .util.Scanner;

public class _16_KokoEatingBananas {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n = in.nextInt();
        int[] piles = new int[n];
        for(int i=0; i<n; i++) {
            piles[i] = in.nextInt();
        }
        int hour = in.nextInt();

        System.out.println(findMinimumEatingSpeed(piles, n, hour));
        
        in.close();
    }

    private static int findMinimumEatingSpeed(int[] piles, int n, int hour) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }

        int low = 1;
        int high = max;
        while(low <= high) {
            int mid = low + (high-low) / 2;
            if(isMinimumSpeed(piles, mid, hour) == true) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean isMinimumSpeed(int[] piles, int noOfBanana, int hour) {
        int sumOfHour = 0;
        for(int i=0; i<piles.length; i++) {
            sumOfHour += Math.ceil( (double)piles[i] / noOfBanana );
            if(sumOfHour>hour) {
                return false;
            }
        }
        if(sumOfHour <= hour) return true;
        return false;
    }

}
