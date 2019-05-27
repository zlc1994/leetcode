package util;

public class ElementalSort {
    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    SortUtil.swap(array, j, j+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = SortUtil.newRandomArray(100);

        bubbleSort(array);

        System.out.println(SortUtil.isSorted(array));
    }
}
