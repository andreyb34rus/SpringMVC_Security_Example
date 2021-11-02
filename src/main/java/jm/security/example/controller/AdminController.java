package jm.security.example.controller;

import jm.security.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping(value = "")
    public String getAdminPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/usersList";
    }
}
