package lesson4;

public class thirdTask {
    public static void main(String[] args) {
        int a = 1;
        int b = 50;
        int c = 3;
        int d = 68;

        boolean x = compareSums(a, b, c, d);
        System.out.println(x);

    }

    public static boolean compareSums(int a, int b, int c, int d) {
        if (sum(a, b) > sum1(c, d))
            return true;
        else
            return false;
    }


    public static long sum(int a, int b) {
        long sum = 0;
        for (int s = a; s <= b; s++) {
            sum += s;
        }
        return sum;
    }

    public static long sum1(int c, int d) {
        long sum1 = 0;
        for (int s = c; s <= d; s++) {
            sum1 += s;
        }
        return sum1;

    }
}