package util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortUtil {
    private static final Random RANDOM = new SecureRandom();

    public static int[] newRandomArray(int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = RANDOM.nextInt(Integer.MAX_VALUE);
        }

        return array;
    }

    public static int[] newSortedArray(int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = i;
        }

        return array;
    }

    public static int[] newAlmostSortedArray(int length, double radio) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = i;
        }

        for (int i = 0; i < radio * length; i++) {
            swap(array, RANDOM.nextInt(length - 1), RANDOM.nextInt(length - 1));
        }

        return array;
    }

    public static int[] newReversedArray(int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = length - i;
        }

        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static boolean isSorted(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int tmp = array[i], j = i - 1;

            while (j >= 0 && array[j] > tmp) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = tmp;
        }
    }

    public static void shellSort(int[] array, int[] seq) {
        int n = array.length;
        int m = seq.length;

        for (int x = m - 1; x >= 0; x--) {
            if (seq[x] > n) {
                continue;
            }

            int h = seq[x];
            for (int i = h; i < n; i++) {
                // do insertion sort in gap h
                int tmp = array[i], j = i - h;

                while (j >= 0 && array[j] > tmp) {
                    array[j+h] = array[j];
                    j -= h;
                }

                array[j+h] = tmp;
            }
        }
    }
}
