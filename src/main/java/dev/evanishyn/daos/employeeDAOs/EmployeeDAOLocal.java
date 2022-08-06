package dev.evanishyn.daos.employeeDAOs;

import dev.evanishyn.entities.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDAOLocal implements EmployeeDAO{

    private Map<Integer, Employee> employeeTable = new HashMap<>();
    private int idMaker = 1;


    //-----------POST-----------
    @Override
    public Employee createEmployee(Employee employee){
        //Set the employee id
        employee.setEmp_id(idMaker);

        //increase idMaker by one (for next new employee)
        idMaker++;

        //put the employee in hashTable with id getter and the employee object
        employeeTable.put(employee.getEmp_id(), employee);

        //return the created employee
        return employee;
    }

    //-----------GET-----------
    @Override
    public Map<Integer,Employee> getEmployeeList() {
        //why returning null? Doesn't it return ListArray of all employees?
        return this.employeeTable;
    }

    @Override
    public Employee getEmployeeById(int id) {
        //Access the employee hash map and pass in id with get method;
        return employeeTable.get(id);
    }


    //-----------PUT-----------
    @Override
    public Employee updateEmployeeInfo(Employee employee) {
        //overwrite the spot in the map
        //use put method with employee hash map to 1) get the id, and 2) place the new object
        employeeTable.put(employee.getEmp_id(), employee);
        return employee;
    }

    //-----------DELETE-----------
    @Override
    public boolean deleteEmployeeAccount(int id) {
        //Create a variable to
        Employee exEmployee = employeeTable.remove(id);
        return exEmployee != null;
//        return exEmployee == null ? false : true;

    }








}
