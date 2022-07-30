package dev.evanishyn.services;

import dev.evanishyn.daos.EmployeeDAO;
import dev.evanishyn.entities.Employee;
import dev.evanishyn.handlers.RegisterEmployeeHandler;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee registerEmployeeAccount(Employee employee){

        if(employee.getfName().length() == 0 || employee.getlName().length() == 0){
            throw new RuntimeException("Employee's first and/or last name cannot be empty.");
        }
//        if (employee.containsIllegalSymbol(employee.getEmail()) == true){   //check if email has no extra special characters
//            throw new RuntimeException("Email must not contain any special symbols.")
//        }
        if(employee.getEmail().length() == 0 || employee.getPhoneNumber().length() == 0){
            throw new RuntimeException("You must include a phone number and email address.");
        }
        if(employee.getPassword().length() < 6){
            throw new RuntimeException("Your password must be longer than 6 characters.");
        }

        Employee newEmployeeInfo = this.employeeDAO.createEmployee(employee);

        return newEmployeeInfo;
    }


    @Override
    Employee retrieveEmployeeById(int id);

    @Override
    Employee updateEmployeeInfo(Employee employee);

    @Override
    boolean deleteEmployeeAccount(int id);

}