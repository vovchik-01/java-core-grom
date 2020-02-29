package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;
import lesson20.task1.exception.UserNotFoundException;

public class UserRepository {

    private User[] users = new User[10];

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


    public User save(User user) throws Exception {

        if (user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved.");
        }

        int index = 0;
        for (User us : users) {
            if (us == null) {
                users[index] = user;
                return users[index];
            }
            index++;

        }
        throw new InternalServerException("Not enough space to save user with id: " + user.getId());

    }

    public User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return user;
            }
        }
        throw new UserNotFoundException("User with id: " + id + "not found");

    }


    public User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't update null user");
        findById(user.getId());
        int index = 0;
        for (User us : users) {
            if (us != null && us.getId() == user.getId()) {
                users[index] = user;
                return users[index];
            }
            index++;
        }
        throw new InternalServerException("Unexpected error");
    }


    public void delete(long id) throws Exception{

        findById(id);

        int index = 0;
        for (User us : users){
            if (us.getId()==id){
                users[index] = null;
                break;
            }
            index++;
        }

    }


}

