package dev.evanishyn.services;

import dev.evanishyn.entities.Employee;

//    Business Rules:
//    All expenses have a single employee as the issuer
//    Expenses start as pending and must then be approved or denied
//           Once approved or denied they CANNOT be deleted or edited
//    Negative expenses are not allowed

public interface EmployeeService {

    Employee registerEmployeeAccount(Employee employee);

    Employee retrieveEmployeeById(int id);

    Employee updateEmployeeInfo(Employee employee);

    boolean deleteEmployeeAccount(int id);


}

