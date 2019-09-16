package lesson9.homeWorks;

public class UserRepository {

    private User[] users;


    public UserRepository(User[] users) {

        this.users = users;
    }


    public User[] getUsers() {

        return users;
    }

    public int countUsers() {
        int countUsers = 0;
        for (User user : users) {
            if (user != null)
                countUsers++;
        }
        return countUsers;
    }

    public String[] getUserNames() {
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


    public long[] getUserIds() {
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


    public String getUserNameById(long id) {
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

    public User getUserByName(String name) {
        for (User user : users) {
            if (user != null && name.equals(user.getName())) {
                return user;
            }

        }
        return null;
    }

    public User getUserById(long id) {
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return user;
            }
        }
        return null;

    }

    public User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user != null && sessionId.equals(user.getSessionId())) {
                return user;
            }

        }
        return null;
    }


    public User save(User user) {

        if (user == null)
            return null;

        if (findById(user.getId()) != null)
            return null;

        int index = 0;
        for (User us : users) {
            if (us == null) {
                users[index] = user;
                return users[index];
            }
            index++;

        }
        return null;

    }

    public User findById(long id) {
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return user;
            }
        }
        return null;

    }

    public User update(User user) {

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

    public void delete(long id) {
        for (int a = 0; a < users.length; a++) {
            if (users[a] != null && id == users[a].getId()) {
                users[a] = null;
            }

        }
    }


}

