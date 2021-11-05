package jm.security.example.dao;

import jm.security.example.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);
    User getUserById(long id);
    List<User> getAllUsers();
    void save(User user);
    void update(User user);
    void delete(long id);
}
