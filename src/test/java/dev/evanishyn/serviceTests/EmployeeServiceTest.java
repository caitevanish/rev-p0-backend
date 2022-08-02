package dev.evanishyn.serviceTests;

import dev.evanishyn.entities.Employee;
import dev.evanishyn.services.EmployeeService;
import dev.evanishyn.services.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeServiceTest {


    public EmployeeService employeeService = new EmployeeServiceImpl();

    //Post
    @Test
    void create_employee_no_errors() {
    Employee testEmp = new Employee(0, "Caitlin", "Evanishyn", "ce@email.com", "12345", "4805558445", 0);
    Employee savedEmployee = employeeService.registerEmployeeAccount(testEmp);
    Assertions.assertEquals(1, savedEmployee.getId());
    }

    //Get

    //Put

    //Patch

    //Delete


}
