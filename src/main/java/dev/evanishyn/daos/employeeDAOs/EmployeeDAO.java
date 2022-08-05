package dev.evanishyn.daos.employeeDAOs;

import dev.evanishyn.entities.Employee;

import java.util.Map;

public interface EmployeeDAO {

    //post
    Employee createEmployee(Employee employee);

    //get
    Employee getEmployeeById(int id);

    Map<Integer, Employee> getEmployeeList();
//    Map<Integer, Employee> getEmployeeList();

    //put
    Employee updateEmployeeInfo(Employee employee);

    //delete
    boolean deleteEmployeeAccount(int id);

}
