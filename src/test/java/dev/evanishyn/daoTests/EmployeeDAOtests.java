package dev.evanishyn.daoTests;

import dev.evanishyn.daos.employeeDAOs.EmployeeDAO;
import dev.evanishyn.daos.employeeDAOs.EmployeeDAOLocal;
import dev.evanishyn.entities.Employee;
import org.junit.jupiter.api.*;

import java.util.Map;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class EmployeeDAOtests {

    static EmployeeDAO employeeDao = new EmployeeDAOLocal();

    //Post
    @Test   //Passed
    @Order(1)
    void create_employee_test(){    //PASSED
        Employee employee = new Employee(0, "Caitlin", "Evanishyn");
        Employee savedEmployee = employeeDao.createEmployee(employee);
        Assertions.assertNotEquals(0, savedEmployee.getId());
    }

    //Get
    @Test   //Passed
    @Order(2)
    void get_all_employees_test(){
        Employee employee1 = new Employee(0, "Moira", "Rose");
        Employee employee2 = new Employee(0, "David", "Rose");
        Employee employee3 = new Employee(0, "Johnny", "Rose");

        employeeDao.createEmployee(employee1);
        employeeDao.createEmployee(employee2);
        employeeDao.createEmployee(employee3);

        Map<Integer, Employee> employeeList = employeeDao.getEmployeeList();
        Assertions.assertEquals(4,employeeList.size());
    }

    @Test   //Passed
    @Order(3)
    void get_employee_by_id(){
        Employee employee = employeeDao.getEmployeeById(1);
        Assertions.assertEquals("Caitlin", employee.getfName());

    }

    //Put
    @Test   //Passed
    @Order(4)
    void update_employee_test(){
        Employee employee = new Employee(1, "Daniel", "Troup");
        employeeDao.updateEmployeeInfo(employee);
        Employee freshEmployee = employeeDao.getEmployeeById(1);
        Assertions.assertEquals( "Daniel", freshEmployee.getfName());
    }

    //Delete
    @Test
    @Order(5)
    void delete_employee_test(){
        boolean result = employeeDao.deleteEmployeeAccount(1);
        Assertions.assertTrue(result);
    }


}
