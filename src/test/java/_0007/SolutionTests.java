package _0007;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTests {
    private static final int a = 321;

    private static final int b = 2147483647;

    private static final Solution solution = new Solution();

    @Test
    void testReverse() {
        assertEquals(123, solution.reverse(a));
        assertEquals(0, solution.reverse(b));
    }
}
