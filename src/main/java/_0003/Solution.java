package _0003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//3. Longest Substring Without Repeating Characters
//
//Medium
//
//Given a string, find the length of the longest substring without repeating characters.
//
//Example 1:
//
//Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring4(s);
    }

    public boolean hasRepeatChar(String s, int start, int end) {
        Set<Character> set = new HashSet<>();

        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return true;
            }
            set.add(s.charAt(i));
        }

        return false;
    }

    /**
    * Description: brute force time limit exceed
    * Param: [s]
    * return: int
    * Author: zlc1994
    * Date: 2019-05-15 16:51
    */
    public int lengthOfLongestSubstring1(String s) {
        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (!hasRepeatChar(s, i, j) && j - i > result) {
                    result = j - i;
                }
            }
        }
        return result;
    }

    /**
    * Description: slide window
    * Param: [s]
    * return: int
    * Author: zlc1994
    * Date: 2019-05-15 17:22
    */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set =  new HashSet<>();
        int result = 0, i = 0, j = 0;

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return result;
    }

    /**
    * Description: slide windows optimize with map
    * Param: [s]
    * return: int
    * Author: zlc1994
    * Date: 2019-05-15 18:01
    */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            result = Math.max(result, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return result;
    }

    /**
    * Description: slide windows optimize with array assume all chars are in ascii table
    * Param: [s]
    * return: int
    * Author: zlc1994
    * Date: 2019-05-16 09:50
    */
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length();
        int result = 0;
        int[] array = new int[128];

        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(array[s.charAt(j)], i);
            result = Math.max(result, j - i + 1);
            array[s.charAt(j)] = j + 1;
        }

        return result;
    }
}