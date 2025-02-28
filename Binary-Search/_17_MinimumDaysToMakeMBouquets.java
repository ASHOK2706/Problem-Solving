/*
LeetCode - 1482
You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make 
m bouquets return -1.

Example 1:
Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3
Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
We need 3 bouquets each should contain 1 flower.
After day 1: [x, _, _, _, _]   // we can only make one bouquet.
After day 2: [x, _, _, _, x]   // we can only make two bouquets.
After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.

Example 3:
Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation: We need 2 bouquets each should have 3 flowers.
Here is the garden after the 7 and 12 days:
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that 
bloomed because they are not adjacent.
After day 12: [x, x, x, x, x, x, x]
It is obvious that we can make two bouquets in different ways.
*/

import java.util.Scanner;

public class _17_MinimumDaysToMakeMBouquets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] bloomDay = new int[n];
        for(int i=0; i<n; i++) {
            bloomDay[i] = in.nextInt(); 
        }
        int m = in.nextInt();
        int k = in.nextInt();
        System.out.println(minDayToMakeMBouquets(bloomDay, m, k));
        in.close();
    }

    private static int minDayToMakeMBouquets(int[] bloomDay, int m, int k) {
        int possibleMaxFlower = m * k;
        int n = bloomDay.length;
        if(n < possibleMaxFlower) return - 1;

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if (bloomDay[i] < minDay) {
                minDay = bloomDay[i];
            }
            if(bloomDay[i] > maxDay) {
                maxDay = bloomDay[i];
            }
        }

        int low = minDay, high = maxDay;
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossibleToMakBouquets(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossibleToMakBouquets(int[] bloomDay, int m, int k, int minimumDay) {
        int n = bloomDay.length;
        int flower = 0;
        int noOfBouqutes = 0;
        for(int i=0; i<n; i++) {
            if(bloomDay[i] <= minimumDay) {
                flower++;
            }
            else {
                noOfBouqutes += flower / k;
                flower = 0;
            }

            if (noOfBouqutes >= m) {
                return true;
            }
        }
        noOfBouqutes += flower / k;
        return noOfBouqutes >= m;
    }
}