package _0009;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTests {
    private static final Solution solution = new Solution();
    @Test
    void testIsPalindrome() {
        assertTrue(solution.isPalindrome(131));
        assertFalse(solution.isPalindrome(132));
    }
}
