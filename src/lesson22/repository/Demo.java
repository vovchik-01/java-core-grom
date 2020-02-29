package lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User user1 = new User(11443, "Daniil", "58656856fgjhfgfiut");

        UserRepository.save(user1);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));


        User user2 = new User(11444, "Andrey", "5hkhjg56fgjhfgfiut");

        UserRepository.save(user2);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user3 = new User(11443, "Anton", "58656856fgjhfgfiut");
        UserRepository.update(user3);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));
        UserRepository.delete(11443);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

    }


}
