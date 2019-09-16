package lesson4;

public class HomeWork3 {
    public static void main(String[] args) {
        if (sum(10, 15) > sum1(5, 10))
            System.out.println(true);
        else
            System.out.println(false);


    }


    public static int sum(int from, int to) {
        int sum1 = 0;
        for (int s = from; s <= to; s++) {
            sum1 += s;
        }
        return sum1;
    }

    public static int sum1(int from, int to) {
        int sum2 = 0;
        for (int s = from; s <= to; s++) {
            sum2 += s;
        }
        return sum2;
    }

}

