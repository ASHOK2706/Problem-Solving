/*
LeetCode - 904. Fruit Into Baskets
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer 
array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of 
fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving 
to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.
Example 1:
Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.

Example 2:
Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

*/

import java.util.Scanner;
import java.util.HashMap;

public class _06_FruitsIntoBaskets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] fruits = new int[n];
        for(int i=0; i<n; i++) {
            fruits[i] = in.nextInt();
        }
        System.out.println(getTotalFruits(fruits));
        in.close();
    }

    private static int getTotalFruits(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int right = 0;
        int maxNoOfFruits = 0;
        int length = 0;
        HashMap<Integer, Integer> basket = new HashMap<>();
        while(right < n) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0)+1);
            while(basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if(basket.get(fruits[left]) == 0) basket.remove(fruits[left]);
                left++;
            }
            if(basket.size() <= 2) {
                length = right - left + 1;
                if(length > maxNoOfFruits) {
                    maxNoOfFruits = length;
                }
            }
            right++;
        }
        return maxNoOfFruits;
    }
}
