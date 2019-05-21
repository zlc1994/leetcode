package _0008;

class Solution {
    public int myAtoi(String str) {
        int n = str.length(), sign = 1, result = 0;
        int i = 0;

        while (i < n) {
            if (str.charAt(i) == ' ') {
                i++;
                continue;
            }

            if (str.charAt(i) == '+') {
                i++;
                break;
            }

            if (str.charAt(i) == '-') {
                i++;
                sign = -1;
                break;
            }

            if (isDigit(str.charAt(i))) {
                break;
            }

            return 0;
        }


        while (i < n && isDigit(str.charAt(i))) {
            int x = sign * (str.charAt(i) - '0');

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && x > 7)) {
                return Integer.MAX_VALUE;
            }

            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && x < -8)) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + x;
            i++;
        }

        return result;
    }

    public boolean isDigit(char c) {
        return (c - '0') >= 0 && (c - '0') <= 9;
    }

}
