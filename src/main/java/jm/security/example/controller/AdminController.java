package jm.security.example.controller;

import jm.security.example.model.User;
import jm.security.example.service.RoleService;
import jm.security.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView showNewUserPage(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/newUser");
        mav.addObject("emptyUser", new User());
        mav.addObject("allRolesList", roleService.getAllRoles());
        return mav;
    }

    @PostMapping("/addUser")
    public String createUser(@ModelAttribute User user,
                             @RequestParam(value = "checkboxResult") String[] checkboxResult) {
        for (String s : checkboxResult) {
            user.addRole(roleService.getRoleByName(s));
        }
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("userRolesList", user.getRoles());
        model.addAttribute("allRolesList", roleService.getAllRoles());
        return "/editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user,
                             @RequestParam(value = "checkboxResult") String[] checkboxResult) {
        for (String s : checkboxResult) {
            user.addRole(roleService.getRoleByName(s));
        }
        userService.update(user);
        return "redirect:/admin";
    }
}
