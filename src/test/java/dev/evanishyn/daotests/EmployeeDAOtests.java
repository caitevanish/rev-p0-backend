package dev.evanishyn.daotests;

import dev.evanishyn.daos.employee_daos.EmployeeDAO;
import dev.evanishyn.daos.employee_daos.EmployeeDAOLocal;
import dev.evanishyn.entities.Employee;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class EmployeeDAOtests {

    EmployeeDAO employeeDao = new EmployeeDAOLocal();

    //Post
    @Test
    void create_employee_test(){
        Employee employee = new Employee(0, "", "Evanishyn", "ce@email.com", "12345", "4805558445", 0);
        Employee savedEmployee = employeeDao.createEmployee(employee);
        Assertions.assertNotEquals(0, savedEmployee.getId());
        System.out.println(savedEmployee);
    }

    //Get

    //Put

    //Delete


}
