package com.bank.welcometochase.controller.manager;

import com.bank.welcometochase.model.User;
import com.bank.welcometochase.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/manage-user")
public class ManagerUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ModelAndView getAllAccessTools() {
        List<User> allUsers = userRepository.findAll();
        return new ModelAndView("manager/manageUsers", "allUsers", allUsers);
    }

    @GetMapping
    @RequestMapping("/emp/{id}")
    public ModelAndView getOneAccessTool(@PathVariable("id") Long id) {
        User user = userRepository.getOne(id);
        return new ModelAndView("manager/oneEmployee", "user", user);
    }
}
