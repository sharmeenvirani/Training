package com.bank.welcometochase.controller.employee;

import com.bank.welcometochase.model.AccessTool;
import com.bank.welcometochase.model.AccessToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeAccessToolController {

    @Autowired
    private AccessToolRepository repository;

    @GetMapping
    public ModelAndView getAllAccessTools() {
        List<AccessTool> accessTools = repository.findAll();
        return new ModelAndView("employee/employeeAccessTools", "accessTools", accessTools);
    }

    @GetMapping
    @RequestMapping("/tool/{id}")
    public ModelAndView getOneAccessTool(@PathVariable("id") Long id) {
        AccessTool tool = repository.getOne(id);
        return new ModelAndView("employee/oneAccessTool", "tool", tool);
    }
}
