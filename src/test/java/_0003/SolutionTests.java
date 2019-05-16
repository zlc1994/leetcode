package _0003;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTests {
    private final static String STRING1 = "pwwkew";

    private final static String STRING2 = "bbbbb";

    private final static String STRING3 = "abcabcbb";

    private final static Solution s = new Solution();

    @Test
    void testLengthOfLongestSubstring1() {
        assertEquals(3, s.lengthOfLongestSubstring1(STRING1));
        assertEquals(1, s.lengthOfLongestSubstring1(STRING2));
        assertEquals(3, s.lengthOfLongestSubstring1(STRING3));
    }

    @Test
    void testLengthOfLongestSubstring2() {
        assertEquals(3, s.lengthOfLongestSubstring2(STRING1));
        assertEquals(1, s.lengthOfLongestSubstring2(STRING2));
        assertEquals(3, s.lengthOfLongestSubstring2(STRING3));
    }

    @Test
    void testLengthOfLongestSubstring3() {
        assertEquals(3, s.lengthOfLongestSubstring3(STRING1));
        assertEquals(1, s.lengthOfLongestSubstring3(STRING2));
        assertEquals(3, s.lengthOfLongestSubstring3(STRING3));
    }

    @Test
    void testLengthOfLongestSubstring4() {
        assertEquals(3, s.lengthOfLongestSubstring4(STRING1));
        assertEquals(1, s.lengthOfLongestSubstring4(STRING2));
        assertEquals(3, s.lengthOfLongestSubstring4(STRING3));
    }
}
