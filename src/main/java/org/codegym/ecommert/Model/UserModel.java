package org.codegym.ecommert.Model;

import org.codegym.ecommert.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private List<User> list;

    public UserModel() {
        list = new ArrayList<>();
        list.add(new User(1, "John Doe", "johndoe@example.com"));
        list.add(new User(2, "Jane Smith", "janesmith@example.com"));
    }

    public List<User> getAllUser() {
        return list;
    }

    public void deleteUser(User user) {
        list.remove(user);
    }

    public User findUserById(int id) {
        for (User user : list) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
