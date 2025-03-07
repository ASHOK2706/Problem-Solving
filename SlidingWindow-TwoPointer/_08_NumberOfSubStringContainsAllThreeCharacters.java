/*
LeetCode - 1358. Number of Substrings Containing All Three Characters
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).

Example 2:
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
*/
import java.util.Scanner;

public class _08_NumberOfSubStringContainsAllThreeCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(countNoOfSubstring(s));
        in.close();
    }

    private static int countNoOfSubstring(String s) {
        int[] hashMap = new int[3];
        for(int i=0; i<3; i++) hashMap[i] = -1;
        int count = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            hashMap[s.charAt(i)-'a'] = i;
            if(hashMap[0] != -1 && hashMap[1] != -1 && hashMap[2] != -1) {
                count += (1 + min(hashMap));
            }
        }
        return count;
    }

    private static int min(int[] hashMap) {
        return (hashMap[0] < hashMap[1]) ? ((hashMap[0] < hashMap[2]) ? hashMap[0] : hashMap[2]) : ((hashMap[1] < hashMap[2]) ? hashMap[1] : hashMap[2]);
    }
}
