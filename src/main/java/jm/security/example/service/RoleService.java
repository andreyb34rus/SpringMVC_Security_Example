package jm.security.example.service;

import jm.security.example.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(long id);
    List<Role> getAllRoles();
}
