package dev.evanishyn.services;

import dev.evanishyn.daos.employee_daos.EmployeeDAO;
import dev.evanishyn.entities.Employee;

import java.util.List;
import java.util.Map;

//---------------------------------------------------------------------------------------
//TO-DO:
// [ ] Make a helper function to validate the new/update employee account info methods.
// - Copy and paste code block in register employee account and call helper function in register and update
//---------------------------------------------------------------------------------------

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }


    //-----------POST-----------
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


    //-----------GET-----------
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

    //-----------PUT-----------

    @Override
    public Employee updateEmployeeInfo(Employee employee){
        //use helper function to validate new info

    return null;
//        return this.employeeDAO.updateEmployeeInfo(Employee employee);
    }


    //-----------DELETE-----------
    @Override
    public boolean deleteEmployeeAccount(int id){
//        boolean isSuccessful = this.employeeDAO.deleteEmployeeAccount(id);
        return this.employeeDAO.deleteEmployeeAccount(id);
    }

}