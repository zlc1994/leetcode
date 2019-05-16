package _0004;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTests {
    private final static int[] nums1 = {1, 2};

    private final static int[] nums2 = {3, 4};

    private final static int[] nums3 = {4, 5};

    private final static int[] nums4 = {1, 2, 3};

    private final static Solution s = new Solution();

    @Test
    void testFindMedianSortedArrays1() {
        assertEquals(2.5, s.findMedianSortedArrays1(nums1, nums2));
        assertEquals(3.0, s.findMedianSortedArrays1(nums3, nums4));
    }

    @Test
    void testFindMedianSortedArrays2() {
        assertEquals(2.5, s.findMedianSortedArrays2(nums1, nums2));
        assertEquals(3.0, s.findMedianSortedArrays2(nums3, nums4));
    }
}
