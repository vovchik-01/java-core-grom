package lesson22.arrays;

public class ArrayUtils {

    public static int maxElement(int[] array) {
        int max = array[0];

        for (int el : array) {
            if (el > max) {
                max = el;
            }
        }
        return max;
    }


    public static int nCount(int[] array, int n) {
        int count = 0;

        for (int el : array) {
            if (el == n) {
                count++;
            }
        }
        return count;
    }

    public static int[] sortAscending(int[] array) {
        int n = array.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }

            }
        }
        return array;
    }

    public static int[] sortDescending(int[] array) {
        int n = array.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (array[j - 1] < array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }

            }
        }
        return array;
    }

}
