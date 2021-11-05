package jm.security.example.dao;

import jm.security.example.model.Role;
import jm.security.example.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);
    List<User> getAllUsers();
    void save(User user);
    void delete(long id);
}
