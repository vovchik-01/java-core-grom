package lesson22.arrays;

public class Demo {
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 76, 45, 53, 1, 2, 5, 7, 8, 9, 10};
        System.out.println(ArrayUtils.nCount(array, 10));
        System.out.println(ArrayUtils.maxElement(array));
        System.out.println(ArrayUtils.sortAscending(array));
        System.out.println(ArrayUtils.sortDescending(array));
    }
}
