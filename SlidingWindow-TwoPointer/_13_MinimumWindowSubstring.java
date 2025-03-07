/*
LeetCode - 76. Minimum Window Substring
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique. 

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
*/

import java.util.Scanner;

public class _13_MinimumWindowSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        System.out.println(getMinimumWindowSubstring(s, t));
        in.close();
    }

    private static String getMinimumWindowSubstring(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] hashMap = new int[256];
        for(int i=0; i<m ; i++) {
            hashMap[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = 0;
        while(right < n) {
            if(hashMap[s.charAt(right)] > 0) count++;
            hashMap[s.charAt(right)]--;
            while (count == m) {
                hashMap[s.charAt(left)]++;
                if(hashMap[s.charAt(left)] > 0) count--;
                if((right - left + 1) < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }
                left++;
            }
            right++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex +minLength);
    }
}
