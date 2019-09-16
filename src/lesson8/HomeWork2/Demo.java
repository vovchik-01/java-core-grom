package lesson8.HomeWork2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

    }


    public static Student createHighestParent() {
        Student student = new Student("Ivan", "Ivanov", 65, new Course[]{});
        return student;


    }

    public static SpecialStudent createLowestChild() {
        SpecialStudent specialStudent = new SpecialStudent("Ivan", "Ivanov", 65, new Course[]{}, 545665456654L, "mail@mail.com");
        return specialStudent;

    }

}
