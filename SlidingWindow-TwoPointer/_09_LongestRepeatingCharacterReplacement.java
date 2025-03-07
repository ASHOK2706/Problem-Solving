/*
LeetCode - 424. Longest Repeating Character Replacement
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase 
English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
*/

import java.util.Scanner;

public class _09_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        System.out.println(characterReplacement(s, k));
        in.close();
    } 

    private static int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int length = 0;
        int maxLength = 0;
        int maxFrequency = 0;
        int[] hashMap = new int[26];

        while(right < n) {
            hashMap[s.charAt(right)-'A']++;
            maxFrequency = (hashMap[s.charAt(right)-'A'] > maxFrequency) ? hashMap[s.charAt(right)-'A'] : maxFrequency;
            while((right - left + 1) - maxFrequency > k) {
                hashMap[s.charAt(left)-'A']--;
                maxFrequency = 0;
                for(int i=0; i<26; i++) {
                    if(hashMap[i] > maxFrequency) {
                        maxFrequency = hashMap[i];
                    }
                }
                left++;
            }
            if((right - left + 1) - maxFrequency <= k) {
                length = right - left + 1;
                if(length > maxLength) maxLength = length;
            }
            right++;
        }
        return maxLength;
    }
}
