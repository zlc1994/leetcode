package _0006;

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
        int n = s.length();

        if (n == 0) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        int gap = numRows - 2;
        int x = n / (gap + numRows);
        int y = n % (gap + numRows);
        int cols;

        if (y == 0) {
            cols = x * (gap + 1);
        } else if (y <= numRows) {
            cols = x * (gap + 1) + 1;
        } else {
            cols = x * (gap + 1) + y - numRows + 1;
        }

        char[][] g = new char[numRows][cols];

        int a, b, xAxis, yAxis;

        for (int i = 0; i < n; i++) {
            a = i / (gap + numRows);
            b = i % (gap + numRows);

            if (b == gap + numRows - 1) {
                xAxis = 1;
                yAxis = (1 + gap) * (a + 1) - 1;
            } else if (b < numRows) {
                xAxis = b;
                yAxis = (1 + gap) * a;
            } else {
                xAxis = 2 * numRows - b - 2;
                yAxis = (1 + gap) * a + (b - numRows + 1);
            }

            g[xAxis][yAxis] = s.charAt(i);
        }

        StringBuilder stringBuilder = new StringBuilder(n);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < cols; j++) {
                if (g[i][j] != 0) {
                    stringBuilder.append(g[i][j]);
                }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.convert("abcde", 3));
    }
}
