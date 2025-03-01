/*
LeetCode - 1011
A conveyor belt has packages that must be shipped from one port to another within days days.
The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor 
belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within 
days days.

Example 1:
Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10
Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like 
(2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

Example 2
Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
*/


import java.util.Scanner;

public class _19_CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weights = new int[n];
        for (int i=0; i<n; i++) {
            weights[i] = in.nextInt();
        }
        int days = in.nextInt();
        System.out.println(findMinimumWeight(weights, days));
        in.close();
    }

    private static int findMinimumWeight(int[] weights, int days) {
        int n = weights.length;
        int sum = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            sum += weights[i];
            if(weights[i] > maxValue) {
                maxValue = weights[i];
            }
        }

        int low = maxValue; 
        int high = sum;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isPossibleToLoad(weights, mid) <= days) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return  low;
    }

    private static int isPossibleToLoad(int[] weights, int wt) {
        int n = weights.length;
        int day = 1;
        int load = 0;
        for(int i=0; i<n; i++) {
            if(load + weights[i] > wt) {
                day += 1;
                load = weights[i];
            }
            else {
                load += weights[i];
            }
        }
        return day;
    }
}
