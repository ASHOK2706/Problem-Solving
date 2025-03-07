/*
LeetCode - 
You are given a string 'str' and an integer ‘K’. Your task is to find the length of the largest substring with at most ‘K’ distinct characters.

For example:
You are given ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.
Sample Input 1:
abbbbbbc 2
abcddefg 3
Sample Output 1:
7
4
*/

import java.util.HashMap;
import java.util.Scanner;

public class _07_LongestSubstringAtMostKDistinctCharacter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        System.out.println(getLengthOfLongestSubstring(s, k));
        in.close();
    }

    private static int getLengthOfLongestSubstring(String s, int k) {
        HashMap<Character, Integer> distinctChatacters = new HashMap<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int length = 0;
        int maxLength = 0;
        while(right < n) {
            distinctChatacters.put(s.charAt(right), distinctChatacters.getOrDefault(s.charAt(right), 0) + 1);
            while(distinctChatacters.size() > k) {
                distinctChatacters.put(s.charAt(left), distinctChatacters.get(s.charAt(left)) - 1);
                if(distinctChatacters.get(s.charAt(left)) == 0) {
                    distinctChatacters.remove(s.charAt(left));
                }
                left++;
            }
            if(distinctChatacters.size() <= k) {
                length = right - left + 1;
                if(length > maxLength) {
                    maxLength = length;
                }
            }
            right ++;
        }
        return maxLength;
    }
}

