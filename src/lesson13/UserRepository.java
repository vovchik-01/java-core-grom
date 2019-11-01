package lesson13;

public class UserRepository {
    private User[] users = new User[10];

    public User save(User user) {
        if (user == null)
            return null;
        if (findByID(user.getId()) != null)
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
         for (User us : users){
             if(us != null && us.getId() == curUserID){
                 users[index] = user;
                 break;
             }
             index++;
         }
         return user;

    }


    public void delete (long id){
        User user = findByID(id);
         int index = 0;
         for (User us : users){
             if (us == user){
                 users[index] = null;
                 break;
             }
             index++;
         }
    }





    private User findByID(long id) {
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    public User[] getUsers() {
        return users;
    }

    public User getFindByID(long id) {
        return findByID(id);
    }
}

