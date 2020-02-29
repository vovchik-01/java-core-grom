package lesson16;

import java.util.Arrays;

public class StringCompare {
    public static void main(String[] args) {

        System.out.println(new String("abc") == new String("abc"));
        System.out.println(new String("abc").equals(new String("abc")));


        System.out.println("abc" == "abc");


        System.out.println("Abc".equals("abc"));// сравнивает каждый чар в стринге

        String s1 = "test";
        String s2 = "test";

        System.out.println(s1 == s2);


        //принудительно добавляет стринг в стрингпул
        String s3 = new String("pppp");
        String s4 = "pppp";
        System.out.println(s3 == s4);
        s3 = s3.intern();
        System.out.println(s3 == s4);


//        test.getBytes(); получает из любого стринга массив байтов
        String str = "testStringVar";
        System.out.println(Arrays.toString(str.getBytes()));
        System.out.println(new String(str.getBytes()));


    }
}
