/*
LeetCode - 131. Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible 
palindrome partitioning of s.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class _20_PolindromPartitioning {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(polindromPartitioning(s));
        in.close();
    }    

    private static List<List<String>> polindromPartitioning(String s) {
        List<List<String>> partitionList = new ArrayList<>();
        getPartitions(0, s, new ArrayList<>(), partitionList);
        return partitionList;
    }

    private static void getPartitions(int index, String s, List<String> list, List<List<String>> partitionList) {
        if(index == s.length()) {
            System.out.println(list);
            partitionList.add(new ArrayList<>(list));
            return;
        }
        for(int i=index; i<s.length(); i++) {
            if(isPolindrom(s, index, i)) {
                list.add(s.substring(index, i+1));
                getPartitions(i + 1, s, list, partitionList);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean isPolindrom(String s, int left, int right) {
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
