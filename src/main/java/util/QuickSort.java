package util;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] array) {
        int n = array.length;

        doSort(array, 0 , n - 1);
    }

    private static void doSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        int p = partition(array, low, high);
        doSort(array, low, p - 1);
        doSort(array, p + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];

        int i = low;
        for (int j = low + 1; j <= high; j++) {
            if (array[j] < pivot) {
                i++;
                SortUtil.swap(array, i, j);
            }
        }

        SortUtil.swap(array, i, low);
        return i;
    }

    public static void main(String[] args) {
        int[] array = SortUtil.newRandomArray(1000000);

        System.out.println(SortUtil.isSorted(array));
    }
}
