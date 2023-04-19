package com.crisscrosscrass.EmployeeCMS.models;

import java.util.List;


public interface EmployeeDao {
    void addEmployee(Employee employee);
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}