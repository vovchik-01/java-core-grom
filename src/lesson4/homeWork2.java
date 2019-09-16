package lesson4;

public class homeWork2 {
    public static void main(String[] args) {
       short a = 1;
       short b = 10;
       int n = 2;
       int res = 0;
       for(short i = a; i <= b; i++) {
           if (i % n == 0)
               res ++;
           }
           System.out.println(res);
       }



}
