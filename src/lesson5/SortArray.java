package lesson5;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] array = {0, 8, 98, 54, 26, 12, 24, 84, 36, 69, 58, 33};
        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));
    }

    public static int[] sortAscending(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int min_i = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = array[i];
                array[i] = array[min_i];
                array[min_i] = tmp;
            }
        }
        return array;


    }


    public static int[] sortDescending(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int max = array[i];
            int max_i = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    max_i = j;
                }
            }
            if (i != max_i) {
                int tmp = array[i];
                array[i] = array[max_i];
                array[max_i] = tmp;
            }
        }
        return array;


    }
}
