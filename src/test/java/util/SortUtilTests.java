package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortUtilTests {
    private static final int length = 100;

    private static final int[] seq = {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929,
            16001, 36289, 64769, 146305, 260609};
    @Test
    void testIsSorted() {
        int[] randomArray = SortUtil.newRandomArray(length);
        assertFalse(SortUtil.isSorted(randomArray));

        int[] sortedArray = SortUtil.newSortedArray(length);
        assertTrue(SortUtil.isSorted(sortedArray));
    }

    @Test
    void testSelectionSort() {
        int[] array = SortUtil.newRandomArray(length);
        SortUtil.selectionSort(array);
        assertTrue(SortUtil.isSorted(array));
    }

    @Test
    void testInsertionSort() {
        int[] array = SortUtil.newRandomArray(length);
        SortUtil.insertionSort(array);
        assertTrue(SortUtil.isSorted(array));
    }

    @Test
    void testShellSort() {
        int[] array = SortUtil.newRandomArray(length);
        SortUtil.shellSort(array, seq);
        assertTrue(SortUtil.isSorted(array));
    }
}
