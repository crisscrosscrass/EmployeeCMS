package com.crisscrosscrass.EmployeeCMS.models;
import ch.qos.logback.core.FileAppender;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.logging.Logger;

public class Employee {
    final static Logger logger = Logger.getLogger(String.valueOf(Employee.class));

    @NotNull
    @Size(min=3,max=20,message="First Name should not be empty")
    private String firstName;

    @Size(min=3,max=20,message="Last Name should not be empty")
    private String lastName;

    @Size(min=3,max=200,message="Email should not be empty")
    private String eMail;
    @NotNull
    private double salary;
    private int employeeId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", salary=" + salary +
                ", employeeId=" + employeeId +
                '}';
    }
}
