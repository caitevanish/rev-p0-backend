package dev.evanishyn.services;

import dev.evanishyn.daos.employee_daos.EmployeeDAO;
import dev.evanishyn.entities.Employee;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee registerEmployeeAccount(Employee employee){

        if(employee.getfName().length() == 0 || employee.getlName().length() == 0){
//        if(employee.getfName().contains(null) || employee.getlName().contains(null)){
            throw new RuntimeException("Employee's first and/or last name cannot be empty.");
        }
//        if (employee.containsIllegalSymbol(employee.getEmail()) == true){   //check if email has no extra special characters
//            throw new RuntimeException("Email must not contain any special symbols.")
//        }
        if(employee.getEmail().length() == 0 || employee.getPhoneNumber().length() == 0){
            throw new RuntimeException("You must include a phone number and email address.");
        }
        if(employee.getPassword().length() <= 5){
            throw new RuntimeException("Your password must be 6 or more characters long.");
        }

//        Employee newEmployeeInfo =    //??

        return this.employeeDAO.createEmployee(employee);
    }



    @Override
    public Employee getEmployeeById(int id){
        return this.employeeDAO.getEmployeeById(id);
    }

    @Override
    public List<Employee> getEmployeeList(){
        return employeeDAO.getEmployeeList();
    }
//    public Map<Integer, Employee> getEmployeeList(){
//        return employeeDAO.getEmployeeList();
//    }

    @Override
    public Employee updateEmployeeInfo(Employee employee){
        return null;
    }

    @Override
    public boolean deleteEmployeeAccount(int id){
        return false;
    }

}