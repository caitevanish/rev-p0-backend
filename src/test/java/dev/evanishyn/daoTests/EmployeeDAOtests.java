package dev.evanishyn.daoTests;

import dev.evanishyn.daos.employee_daos.EmployeeDAO;
import dev.evanishyn.daos.employee_daos.EmployeeDAOLocal;
import dev.evanishyn.entities.Employee;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class EmployeeDAOtests {

    EmployeeDAO employeeDao = new EmployeeDAOLocal();

    //Post
    @Test
    void create_employee_test(){    //PASSED
        Employee employee = new Employee(0, "Caitlin", "Evanishyn");
        Employee savedEmployee = employeeDao.createEmployee(employee);
//        Assertions.assertNotEquals();
        Assertions.assertNotEquals(0, savedEmployee.getId());
        System.out.println(savedEmployee);

    }

    //Get

    //Put

    //Delete


}
