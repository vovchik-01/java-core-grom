package lesson4;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println(concat("Привет!", " Как дела?", " Что нового?"));

    }

    public static String concat(String first, String second, String third){
        String res = first + second + third;
        return res;

    }

}
