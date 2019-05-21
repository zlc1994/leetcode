package _0007;

class Solution {
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int y = x % 10;

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && y > 7)) {
                return 0;
            }

            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && y < -8)) {
                return 0;
            }

            res = res * 10 + y;
            x = x / 10;
        }

        return res;
    }
}
