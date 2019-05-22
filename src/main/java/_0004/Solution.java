package _0004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//4. Median of Two Sorted Arrays
//
//Hard
//
//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//You may assume nums1 and nums2 cannot be both empty.
//
//Example 1:
//
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
//Example 2:
//
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays2(nums1, nums2);
    }

    /**
    * Description: merge two array then calculate
    * Param: [num1, nums2]
    * return: double
    * Author: zlc1994
    * Date: 2019-05-16 10:37
    */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
            } else {
                nums[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            nums[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            nums[k] = nums2[j];
            j++;
            k++;
        }

        if ((m + n) % 2 == 0 ) {
            int mid = (m + n) / 2;
            return (nums[mid] + nums[mid-1]) / 2.0;
        } else {
            return nums[(m+n-1)/2];
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // ensure m <= n
        if (m > n) {
            int[] tmp1 = nums1;
            nums1 = nums2;
            nums2 = tmp1;

            int tmp2 = m;
            m = n;
            n = tmp2;
        }

        int iMin = 0, iMax = m;

        while (iMin <= iMax) {
            // i + j = m - i + n - j + 1 if m + n is odd else i + j = m - i + n - j
            // stop loop when nums1[i-1] <= nums2[j] and nums1[i] >= nums2[j-1] or i, j get to boundary
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;


            if (i < m && nums2[j-1] > nums1[i]) {
                iMin = i + 1; // i is too small, increase i
            } else if (i > 0 && nums1[i-1] > nums2[j]) {
                iMax = i - 1; // i is too large, decrease i
            } else {
                // i is perfect
                int maxLeft, minRight;

                if (i == 0) {
                    maxLeft = nums2[j-1];
                } else if (j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }


                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }
}
