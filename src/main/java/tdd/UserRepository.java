package tdd;

import java.util.LinkedList;
import java.util.List;

public class UserRepository {
    private final List<User> users = new LinkedList<>();

    public List<User> getUsers() {
        return users;
    }

    public boolean addUser(User user) {
        if (user.verification("login", "password")) {
            this.users.add(user);
            return true;
        }

        return false;
    }

    public void nonAdminDecomposition() {
        this.users.removeIf(user -> user.getStatus() == null);
    }
}
