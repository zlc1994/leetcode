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
}
