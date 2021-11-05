package jm.security.example.controller;

import jm.security.example.model.Role;
import jm.security.example.model.RoleTypes;
import jm.security.example.model.User;
import jm.security.example.service.RoleService;
import jm.security.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping(value = "")
    public String getAdminPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/usersList";
    }

    @GetMapping(value = "/newUser")
    public String showNewUserPage(Model model) {
        model.addAttribute("emptyUser", new User());
        return "/newUser";
    }

    @PostMapping("/addUser")
    public String createUser(@ModelAttribute User user, @RequestParam(value = "selectRoles[]") String[] array) {
        Set<Role> setOfRoles = new HashSet<>();
        for (String s : array) {
            setOfRoles.add(roleService.getRoleById(Integer.valueOf(s)));
        }
        user.setRoles(setOfRoles);
        userService.save(user);
        return "redirect:/admin";
    }
}
