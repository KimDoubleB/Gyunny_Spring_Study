package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1, "Gyun1", new Date()));
        users.add(new User(2, "Gyun2", new Date()));
        users.add(new User(3, "Gyun3", new Date()));
    }

    public List<User> findALl() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User delete(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(id - 1);
                return user;
            }
        }
        return null;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
