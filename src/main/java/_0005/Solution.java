package _0005;

//5. Longest Palindromic Substring
//
// Medium
//
// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//Example 1:
//
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//Example 2:
//
//Input: "cbbd"
//Output: "bb"
class Solution {
    public String longestPalindrome(String s) {
        return longestPalindrome3(s);
    }

    /**
    * Description: brute force
    * Param: [s]
    * return: java.lang.String
    * Author: zlc1994
    * Date: 2019-05-17 09:52
    */
    public String longestPalindrome1(String s) {
        int result = 0, start = 0, end = 0;
        int n = s.length();

        if (n == 0) {
            return "";
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j) && result < j - i + 1) {
                    result = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public boolean isPalindrome(String s, int start, int end) {
        if (start > end) {
            return false;
        }

        for (int i = start, j = end; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    /**
    * Description: expand from center
    * Param: [s]
    * return: java.lang.String
    * Author: zlc1994
    * Date: 2019-05-17 10:19
    */
    public String longestPalindrome2(String s) {
        int n = s.length(), start = 0, end = 0, result = 0;

        if (n == 0) {
           return "";
        }

        for (int i = 0; i < n; i++) {
           int j = 0, k = 0;

           // expand from s[i]
           while (i - j >= 0 && i + j < n) {
               if (s.charAt(i-j) == s.charAt(i+j)) {
                   if (result < 2 * j + 1) {
                       result = 2 * j + 1;
                       start = i - j;
                       end = i + j;
                   }
                   j++;
               } else {
                   break;
               }
           }

           // expand from s[i], s[i+1]
           while (i < n - 1 && s.charAt(i) == s.charAt(i+1) && i - k >= 0 && i + k + 1 < n) {
               if (s.charAt(i-k) == s.charAt(i+k+1)) {
                   if (result < 2 * (k + 1)) {
                       result = 2 * (k + 1);
                       start = i - k;
                       end = i + k + 1;
                   }
                   k++;
               } else {
                   break;
               }
           }
        }

        return s.substring(start, end + 1);
    }

    public String longestPalindrome3(String s) {
        int n = s.length();

        if (n == 0) {
            return "";
        }

        // preprocess
        int iMirror, c = 0, r = 0, m = 2 * n + 3;
        int[] p = new int[m];
        char[] t = new char[m];

        t[0] = '^';
        for (int i = 0; i < n; i++) {
            t[2*i+1] = '#';
            t[2*i+2] = s.charAt(i);
        }
        t[m-2] = '#';
        t[m-1] = '$';

        for (int i = 1; i < m - 1; i++) {
            iMirror = c - (i - c);

            if (r > i) {
                p[i] = Math.min(r - i, p[iMirror]);
            }

            while (t[i+p[i]+1] == t[i-p[i]-1]) {
                p[i]++;
            }

            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }

        int maxP = 0, maxI = 0;

        for (int i = 1; i < m - 1; i++) {
            if (p[i] > maxP) {
                maxP = p[i];
                maxI = i;
            }
        }

        int start = (maxI - p[maxI]) / 2;

        return s.substring(start, start + p[maxI]);
    }
}
