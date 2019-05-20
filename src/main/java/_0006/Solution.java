package _0006;

import java.util.ArrayList;
import java.util.List;

//6. ZigZag Conversion
//
// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//And then read line by line: "PAHNAPLSIIGYIR"
//
//Write the code that will take a string and make this conversion given a number of rows:
//
//string convert(string s, int numRows);
//Example 1:
//
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
//Example 2:
//
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
class Solution {
    public String convert(String s, int numRows) {
        return convert1(s, numRows);
    }

    public String convert1(String s, int numRows) {
        int n = s.length();

        if (n == 0) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> stringBuilders = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, n); i++) {
            stringBuilders.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (int i = 0; i < n; i++) {
            stringBuilders.get(currentRow).append(s.charAt(i));
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (StringBuilder stringBuilder1 : stringBuilders) {
            stringBuilder.append(stringBuilder1);
        }

        return stringBuilder.toString();
    }

    public String convert2(String s, int numRows) {
        int n = s.length();

        if (n == 0) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < n; j += cycleLen) {
                stringBuilder.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    stringBuilder.append(s.charAt(j + cycleLen - i));
                }
            }
        }

        return stringBuilder.toString();
    }
}
