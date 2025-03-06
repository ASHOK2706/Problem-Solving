/*
LeetCode - 3 Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.util.Scanner;

public class _04_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(findLengthOfLongestSubstring(s));
        in.close();
    }

    private static int findLengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int[] hashMap = new int[256];
        for (int i=0; i<256; i++) {
            hashMap[i]  = -1;
        }

        while (right < n) {
            if(hashMap[s.charAt(right)] != -1) {
                if(left <= hashMap[s.charAt(right)]) {
                    left = hashMap[s.charAt(right)] + 1;
                }
            }
            int length = right - left + 1;
            if(length > maxLength) {
                maxLength = length;
            }
            hashMap[s.charAt(right)] = right;
            right++;
        }

        return maxLength;
    }
}
