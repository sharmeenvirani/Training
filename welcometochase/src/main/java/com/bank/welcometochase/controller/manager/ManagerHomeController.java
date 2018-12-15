package com.bank.welcometochase.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manager-home")
public class ManagerHomeController {

    @GetMapping
    public String getAllAccessTools() {
        return "manager/managerHome";
    }
}
