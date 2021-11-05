package jm.security.example.service;

import jm.security.example.model.Role;
import jm.security.example.model.User;

import java.util.List;

public interface UserService {

    User getUserByName(String name);
    List<User> getAllUsers();
    void save(User user);
}
