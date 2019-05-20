package _0006;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTests {
    private static final String s1 = "PAYPALISHIRING";

    private static final Solution s = new Solution();

    @Test
    void testCovert1() {
        assertEquals("PAHNAPLSIIGYIR", s.convert1(s1, 3));
        assertEquals("PINALSIGYAHRPI", s.convert1(s1, 4));
    }

    @Test
    void testCovert2() {
        assertEquals("PAHNAPLSIIGYIR", s.convert2(s1, 3));
        assertEquals("PINALSIGYAHRPI", s.convert2(s1, 4));
    }
}
