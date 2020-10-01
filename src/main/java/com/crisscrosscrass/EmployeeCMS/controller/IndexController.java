package com.crisscrosscrass.EmployeeCMS.controller;

import com.crisscrosscrass.EmployeeCMS.models.Employee;
import com.crisscrosscrass.EmployeeCMS.models.EmployeeData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class IndexController implements WebMvcConfigurer {
    final static Logger logger = Logger.getLogger(String.valueOf(IndexController.class));

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/add").setViewName("adding");
    }

    @GetMapping("/")
    public String showIndex(@RequestParam(name="name", required = false, defaultValue="Spring-User") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("myEmployeeList", EmployeeData.getAll());
        return "EmployeeCMS/index";
    }
    @GetMapping("/add")
    public String showAddEmployee(Employee employee) {
        return "EmployeeCMS/add";
    }
    @GetMapping("/remove")
    public String showRemoveEmployee(Model model) {
        model.addAttribute("myEmployeeList",EmployeeData.getAll());
        return "EmployeeCMS/remove";
    }
    @PostMapping("/update")
    public String showUpdateEmployee(Employee employee, Model model){
        Employee searchedEmployee = EmployeeData.getById(employee.getEmployeeId());
        model.addAttribute("myEmployee",searchedEmployee);
        return "EmployeeCMS/update";
    }
    @PostMapping("/detail")
    public String showDetailEmployee(Employee employee, Model model){
        Employee searchedEmployee = EmployeeData.getById(employee.getEmployeeId());
        model.addAttribute("myEmployee",searchedEmployee);
        return "EmployeeCMS/detail";
    }

}
