package dev.evanishyn.serviceTests;

import dev.evanishyn.daos.employeeDAOs.EmployeeDAO;
import dev.evanishyn.daos.employeeDAOs.EmployeeDAOLocal;
import dev.evanishyn.entities.Employee;
import dev.evanishyn.entities.Expense;
import dev.evanishyn.services.EmployeeService;
import dev.evanishyn.services.EmployeeServiceImpl;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class EmployeeServiceTest {

    static EmployeeDAO employeeDAO = new EmployeeDAOLocal();
    static EmployeeService employeeService = new EmployeeServiceImpl(employeeDAO);

    //Post
    @Test   //PASSED
    @Order(1)
    void create_employee_no_errors() {
        Employee testEmp = new Employee(0, "Caitlin", "Evanishyn");
        Employee savedEmployee = employeeService.registerEmployeeAccount(testEmp);
        Assertions.assertEquals(1, savedEmployee.getEmp_id());
    }

    @Test   //Fix the registerEmployeeAccount name verification
    @Order(2)
    void create_employee_some_errors() {
        Employee testEmp = new Employee(0, "C", "Evanishyn");
        Assertions.assertEquals("", employeeService.registerEmployeeAccount(testEmp).getfName());
//            Employee savedEmployee = employeeService.registerEmployeeAccount(testEmp);
//            Assertions.assertNotEquals(1, savedEmployee.getId());
    }

    //Get
    @Test
    @Order(3)
    void get_all_employees_test(){
        Employee employee1 = new Employee(0, "Moira", "Rose");
        Employee employee2 = new Employee(0, "David", "Rose");
        Employee employee3 = new Employee(0, "Johnny", "Rose");

        employeeService.registerEmployeeAccount(employee1);
        employeeService.registerEmployeeAccount(employee2);
        employeeService.registerEmployeeAccount(employee3);

        List<Employee>  employeeList = employeeService.getEmployeeList();
        Assertions.assertEquals(5,employeeList.size());
    }


    //Put
    @Test
    void update_employee_test(){    //
        Employee employeeV1 = new Employee(1, "Daniel", "Troup");
        employeeService.registerEmployeeAccount(employeeV1);
        Employee employeeV2 = new Employee(1, "Daniel", "Evanishyn");
        employeeService.updateEmployeeInfo(employeeV2);
        employeeV1 = employeeService.updateEmployeeInfo(employeeV2);
        Assertions.assertEquals( "Evanishyn" , employeeV1.getlName());
    }

        //Delete
    @Test
    @Order(5)
    void delete_employee_test(){
        boolean result = employeeService.deleteEmployeeAccount(1);
        Assertions.assertTrue(result);
    }




}
