package lesson15.homeWork;

public class UserRepository {

    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }


    public User save(User user) {
        if (user == null)
            return null;
        if (findUser(user) != null)
            return null;
        int countPlaced = 0;
        for (User us : users) {
            if (us != null)
                countPlaced++;
        }
        if (countPlaced > 9)
            return null;
        int index = 0;
        for (User us : users) {
            if (us == null) {
                users[index] = user;
                break;
            }
            index++;
        }

        return user;
    }

    public User update(User user) {
        if (user == null)
            return null;
        User curUser = findByID(user.getId());
        if (curUser == null)
            return null;
        long curUserID = curUser.getId();
        int index = 0;
        for (User us : users) {
            if (us != null && us.getId() == curUserID) {
                users[index] = user;
                break;
            }
            index++;
        }
        return user;
    }


    public void delete(long id) {
        User user = findByID(id);
        int index = 0;
        for (User us : users) {
            if (us == user) {
                users[index] = null;
                break;
            }
            index++;
        }
    }


    public User findUser(User user) {
        for (User us : users) {
            if (us != null && us.equals(user)) {
                return user;
            }
        }
        return null;
    }

    private User findByID(long id) {
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return user;
            }
        }
        return null;
    }

}
