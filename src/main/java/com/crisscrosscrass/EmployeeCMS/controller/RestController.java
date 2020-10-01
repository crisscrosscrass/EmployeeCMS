package com.crisscrosscrass.EmployeeCMS.controller;

import com.crisscrosscrass.EmployeeCMS.models.Employee;
import com.crisscrosscrass.EmployeeCMS.models.EmployeeData;
import com.crisscrosscrass.EmployeeCMS.service.IdManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@org.springframework.web.bind.annotation.RestController
public class RestController implements WebMvcConfigurer {
    final static Logger logger = Logger.getLogger(String.valueOf(RestController.class));
    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees(){
        return EmployeeData.getAll();
    }
    @PostMapping("/addEmployee")
    public Employee createNewEmployee(@RequestBody Employee addNewEmployee){
        addNewEmployee.setEmployeeId(IdManager.getId());
        EmployeeData.add(addNewEmployee);
        logger.info("Employee has been added via Rest Controller");
        logger.info(addNewEmployee.toString());
        return addNewEmployee;
    }
}
