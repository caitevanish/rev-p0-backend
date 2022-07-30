package dev.evanishyn.daos;

import dev.evanishyn.entities.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDAOLocal implements EmployeeDAO{

    private Map<Integer, Employee> employeeTable = new HashMap<>();
    private int idMaker = 1;


    //-----------POST-----------
    @Override
    public Employee createEmployee(Employee employee){
        //Set the employee id
        employee.setId(idMaker);

        //increase idMaker by one (for next new employee)
        idMaker++;

        //put the employee in hashTable with id getter and the employee object
        employeeTable.put(employee.getId(), employee);

        //return the created employee
        return employee;
    }

    //-----------GET-----------
    @Override
    public Employee getEmployeeById(int id) {
        //Access the employee hash map and pass in id with get method;
        return employeeTable.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        //why returning null? Doesn't it return ListArray of all employees?
        return null;
    }

    //-----------PUT-----------
    @Override
    public Employee updateEmployeeInfo(Employee employee) {
        //overwrite the spot in the map
        //use put method with employee hash map to 1) get the id, and 2) place the new object
        employeeTable.put(employee.getId(), employee);
        return employee;
    }

    //-----------DELETE-----------
    @Override
    public boolean deleteEmployee(int id) {
        //Create a variable to
        Employee exEmployee = employeeTable.remove(id);
        return exEmployee == null ? false : true;

    }








}
