package _0008;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTests {
    private static final Solution solution = new Solution();

    private static final String s1 = "42";

    private static final String s2 = "    -42";

    private static final String s3 = "4193 with words";

    private static final String s4 = "words and 987";

    private static final String s5 = "-91283472332";

    private static final String s6 = "999999999999999";

    private static final String s7 = "+-2";

    @Test
    void testMyAtoi() {
        assertEquals(42, solution.myAtoi(s1));
        assertEquals(-42, solution.myAtoi(s2));
        assertEquals(4193, solution.myAtoi(s3));
        assertEquals(0, solution.myAtoi(s4));
        assertEquals(-2147483648, solution.myAtoi(s5));
        assertEquals(2147483647, solution.myAtoi(s6));
        assertEquals(0, solution.myAtoi(s7));
    }
}
