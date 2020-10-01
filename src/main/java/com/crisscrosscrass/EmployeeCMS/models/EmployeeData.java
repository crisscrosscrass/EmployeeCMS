package com.crisscrosscrass.EmployeeCMS.models;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeData {
    static ArrayList<Employee> myEmployeeList = new ArrayList<>();
    public static ArrayList<Employee> getMyEmployeeList() {
        return myEmployeeList;
    }
    public static void add(Employee employee){
        myEmployeeList.add(employee);
        // Sort List by ID could be also written as myEmployeeList.sort(Comparator.comparingInt(Employee::getEmployeeId));
        Collections.sort(myEmployeeList, (e1, e2) -> Integer.valueOf(e1.getEmployeeId()).compareTo(e2.getEmployeeId()));
    }
    public static void remove(int id){
        Employee employeeToRemove = getById(id);
        myEmployeeList.remove(employeeToRemove);
        // Sort List by ID
        Collections.sort(myEmployeeList, (e1, e2) -> Integer.valueOf(e1.getEmployeeId()).compareTo(e2.getEmployeeId()));
    }
    public static Employee getById(int id){
        Employee theSearchedEmployee = null;
        for (Employee employee: myEmployeeList){
            if (employee.getEmployeeId() == id){
                theSearchedEmployee = employee;
            }
        }
        return theSearchedEmployee;
    }
    public static ArrayList<Employee> modifyByIndex(int id, Employee modifiedEmployee){
        if (id != -1){
            myEmployeeList.get(id).setFirstName(modifiedEmployee.getFirstName());
            myEmployeeList.get(id).setLastName(modifiedEmployee.getLastName());
            myEmployeeList.get(id).seteMail(modifiedEmployee.geteMail());
            myEmployeeList.get(id).setSalary(modifiedEmployee.getSalary());
        }
        return myEmployeeList;
    }
    public static int getIndexOfEmployeeData(Employee employeeId){
        for(int i = 0; i < myEmployeeList.size(); i++){
            if(myEmployeeList.get(i).getEmployeeId() == employeeId.getEmployeeId()){
                return i;
            }
        }
        return 0;
    }
    public static ArrayList<Employee> getAll(){
        return myEmployeeList;
    }
}
