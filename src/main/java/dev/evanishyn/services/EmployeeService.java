package dev.evanishyn.services;

import dev.evanishyn.entities.Employee;

import java.util.List;
import java.util.Map;

//    Business Rules:
//    All expenses have a single employee as the issuer
//    Expenses start as pending and must then be approved or denied
//           Once approved or denied they CANNOT be deleted or edited
//    Negative expenses are not allowed

public interface EmployeeService {

    Employee registerEmployeeAccount(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getEmployeeList();
//    Map<Integer, Employee> getEmployeeList();

    Employee updateEmployeeInfo(Employee employee);

    boolean deleteEmployeeAccount(int id);


}

