package com.crisscrosscrass.EmployeeCMS.controller;

import com.crisscrosscrass.EmployeeCMS.models.Employee;
import com.crisscrosscrass.EmployeeCMS.models.EmployeeData;
import com.crisscrosscrass.EmployeeCMS.service.IdManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class ProcessController implements WebMvcConfigurer {
    final static Logger logger = Logger.getLogger(String.valueOf(ProcessController.class));

    @PostMapping("/save")
    public String saveEmployeeInfo(@Valid Employee addNewEmployee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "EmployeeCMS/add";
        }
        addNewEmployee.setEmployeeId(IdManager.getId());
        EmployeeData.add(addNewEmployee);
        logger.info("Employee has been added via Frontend Controller");
        logger.info(addNewEmployee.toString());
        return "redirect:/";
    }
    @PostMapping(value = "/deleteEmployee")
    public String processdeleteOneEmployee(Employee selectedEmployee){
        logger.info("Employee has been removed via Frontend Controller");
        logger.info(selectedEmployee);
        IdManager.saveId(selectedEmployee.getEmployeeId());
        EmployeeData.remove(selectedEmployee.getEmployeeId());
        return "redirect:/";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String processDeleteEmployeeFromList(@RequestParam int[] employeeIds){
        logger.info("Employees has been removed via Frontend Controller");
        for (int employeeId : employeeIds){
            EmployeeData.remove(employeeId);
            IdManager.saveId(employeeId);
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String processUpdateEmployeeFromList(Employee modifiedEmployee){
        logger.info("Employees has been updated via Frontend Controller");
        int indexOfEmployeeData = EmployeeData.getIndexOfEmployeeData(modifiedEmployee);
        EmployeeData.modifyByIndex(indexOfEmployeeData,modifiedEmployee);
        return "redirect:/";
    }
}
