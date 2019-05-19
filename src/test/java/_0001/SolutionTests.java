package _0001;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTests {
    private final static Solution solution = new Solution();

    private final static int[] nums = {2, 7, 11, 15};

    @Test
    void testTwoSum1() {
        int[] result = solution.twoSum1(nums, 9);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    void testTwoSum2() {
        int[] result = solution.twoSum2(nums, 9);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }
}
