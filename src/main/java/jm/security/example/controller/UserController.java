package jm.security.example.controller;

import jm.security.example.service.UserDetailsServiceImpl;
import jm.security.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String getHomePage() {
        return "/index";
    }

    @GetMapping(value = "/user")
    public String getUserPage(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByName(principal.getName()));
        return "/user";
    }
}
