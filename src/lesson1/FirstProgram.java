package lesson1;

import lesson9.utils.Checker;

public class FirstProgram {
    public static void main(String[] args) {
        System.out.println("My First Java program...");
        System.out.println("Done");

        Checker checker = new Checker();
        checker.checkCompanyName("Google");

    }
}
