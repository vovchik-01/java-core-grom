package lesson16;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {


        String test = "someStringExample";

        System.out.println(test.isEmpty()); // проверяет пустой ли наш стринг
        System.out.println("".isEmpty()); // пустой стринг

        System.out.println(test.length()); // возвращает длину стринга

        System.out.println(test.charAt(2)); // выводит чар находящийся на конкретной позиции


        System.out.println(test.replace("me", "T")); // заменяет один чар или стринг на другой

        System.out.println(test.replaceAll("me", "T"));
        // String regex - {a-Z}; набор стрингов. Используется для валидации.


        System.out.println(test.contains("me")); // проверяеи содержит ли стринг последовательность чаров с учетом регистра


        System.out.println(Arrays.toString(test.split("e"))); //делит стринг на массив подстрингов. в кавычках
        //указывается по какому знаку разделить стринг
        String phrase = "Hello there guys";
        System.out.println(Arrays.toString(phrase.split(" ")));


        System.out.println(" test ".trim()); // удаляет пробелы в начале или конце стринга


        System.out.println(phrase.substring(5)); //возвращает подстринг с определенной позиции
        System.out.println(phrase.substring(5, 8).trim()); // тоже но с и по позицию, без последней


        System.out.println(test.toUpperCase()); // все буквы приводит к большим
        System.out.println(test.toLowerCase()); // все буквы приводит к маленьким

        test.getBytes();
        test.equals("eeee");
        System.out.println(test);
        test.intern();
        System.out.println(test);


    }
}
