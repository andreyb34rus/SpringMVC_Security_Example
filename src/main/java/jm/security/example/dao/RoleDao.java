package jm.security.example.dao;

import jm.security.example.model.Role;
import jm.security.example.model.User;

import java.util.List;

public interface RoleDao {

    Role getRoleById(long id);
    List<Role> getAllRoles();
}
