package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SortUtilTests {
    private static final int length = 100;
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
        SortUtil.shellSort(array);
        assertTrue(SortUtil.isSorted(array));
    }
}
