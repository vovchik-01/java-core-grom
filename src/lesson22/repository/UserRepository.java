package lesson22.repository;

public class UserRepository {

    private static User[] users = new User[10];


    public UserRepository() {

    }


    public static User[] getUsers() {

        return users;
    }

    public static int countUsers() {
        int countUsers = 0;
        for (User user : users) {
            if (user != null)
                countUsers++;
        }
        return countUsers;
    }

    public static String[] getUserNames() {
        String[] massOfNames = new String[users.length];
        int index = 0;

        for (User user : users) {
            if (user != null) {
                massOfNames[index] = user.getName();
                index++;
            }
        }
        return massOfNames;
    }


    public static long[] getUserIds() {
        long[] massOfIds = new long[countUsers()];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                massOfIds[index] = user.getId();
                index++;
            }

        }
        return massOfIds;
    }


    public static String getUserNameById(long id) {
        String name = "";
        int count = 0;
        for (User user : users) {
            if (user != null && id == user.getId()) {
                name = user.getName();
                count++;
            }
            if (count == 0)
                return null;
        }
        return name;
    }

    public static User getUserByName(String name) {
        for (User user : users) {
            if (user != null && name.equals(user.getName())) {
                return user;
            }

        }
        return null;
    }

    public static User getUserById(long id) {
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return user;
            }
        }
        return null;

    }

    public static User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user != null && sessionId.equals(user.getSessionId())) {
                return user;
            }

        }
        return null;
    }


    public static User save(User user) {

        if (user == null)
            return null;

        if (findById(user.getId()) != null)
            return null;

        int countPlaced = 0;
        for (User us : users) {
            if (us != null) {
                countPlaced++;
            }
        }
        if (countPlaced > 9) {
            return null;
        }

        int index = 0;
        for (User us : users) {
            if (us == null) {
                users[index] = user;
                return users[index];
            }
            index++;

        }
        return user;

    }

    public static User findById(long id) {
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return user;
            }
        }
        return null;

    }

    public static User update(User user) {

        if (user == null)
            return null;

        if (findById(user.getId()) == null)
            return null;

        int index = 0;
        for (User us : users) {
            if (us == findById(user.getId())) {
                users[index] = user;
                return users[index];
            }
            index++;

        }
        return null;


    }

    public static void delete(long id) {
        for (int a = 0; a < users.length; a++) {
            if (users[a] != null && id == users[a].getId()) {
                users[a] = null;
            }

        }
    }


}

