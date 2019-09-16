package lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int sum = 0;
        int x = 1234;
        for (int a = 0; a <= 1000; a++) {
            sum += a;
        }

        int b = sum / x;
        int c = sum % x;

        boolean answer = c > b;
        System.out.println(answer);
    }
}
