package dev.evanishyn.services;

import dev.evanishyn.daos.employeeDAOs.EmployeeDAO;
import dev.evanishyn.entities.Employee;

import java.util.List;
import java.util.Map;

//---------------------------------------------------------------------------------------
//TO-DO:
// [ ] Make a helper function to validate the new/update employee account info methods.
// - Copy and paste code block in register employee account and call helper function in register and update
//---------------------------------------------------------------------------------------

public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDAO employeeDAO;

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

    //-----------PUT-----------

    @Override
    public Employee updateEmployeeInfo(Employee employee){
        //use helper function to validate new info
        if (employee.getfName().length() == 0 || employee.getlName().length() == 0){
            throw new RuntimeException("Employee's first and/or last name cannot be empty.");
        }
    return this.employeeDAO.updateEmployeeInfo(employee);
    }


    //-----------DELETE-----------
    @Override
    public boolean deleteEmployeeAccount(int id){
//        boolean isSuccessful = this.employeeDAO.deleteEmployeeAccount(id);
        return this.employeeDAO.deleteEmployeeAccount(id);
    }

}