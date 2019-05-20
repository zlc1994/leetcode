package _0005;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTests {
    private final static Solution s = new Solution();

    private final static String string1 = "cbbd";

    private final static String string2 = "babad";

    private Set<String> set = new HashSet<>();

    @BeforeEach
    void setUp() {
        set.add("bab");
        set.add("aba");
    }


    @Test
    void testLongestPalindrome1() {
        assertEquals("bb", s.longestPalindrome1(string1));
        assertTrue(set.contains(s.longestPalindrome1(string2)));
    }

    @Test
    void testLongestPalindrome2() {
        assertEquals("bb", s.longestPalindrome1(string1));
        assertTrue(set.contains(s.longestPalindrome1(string2)));
    }

    @Test
    void testLongestPalindrome3() {
        assertEquals("bb", s.longestPalindrome3(string1));
        assertTrue(set.contains(s.longestPalindrome3(string2)));
    }
}
