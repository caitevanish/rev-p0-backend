package dev.evanishyn.daos.employeeDAOs;

import dev.evanishyn.entities.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {

    //post
    Employee createEmployee(Employee employee);

    //get
    Employee getEmployeeById(int id);

    List<Employee> getEmployeeList();

    //put
    Employee updateEmployeeInfo(Employee employee);

    //delete
    boolean deleteEmployeeAccount(int id);

}
