package _0001;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTests {
    private final static Solution solution = new Solution();

    private final static int[] nums = {2, 7, 11, 15};

    @Test
    @DisplayName("nums[0] + nums[1] = 2 + 7 = 9")
    void testTwoSumEqual9() {
        int[] result = solution.twoSum(nums, 9);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }
}
