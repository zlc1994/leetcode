package _0006;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTests {
    private static final String s1 = "PAYPALISHIRING";

    private static final Solution s = new Solution();

    @Test
    void testCovert() {
        assertEquals("PAHNAPLSIIGYIR", s.convert(s1, 3));
        assertEquals("PINALSIGYAHRPI", s.convert(s1, 4));
    }
}
