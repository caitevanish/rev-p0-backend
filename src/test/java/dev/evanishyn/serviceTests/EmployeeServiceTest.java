package dev.evanishyn.serviceTests;

import dev.evanishyn.app.App;
import dev.evanishyn.daos.employee_daos.EmployeeDAO;
import dev.evanishyn.daos.employee_daos.EmployeeDAOLocal;
import dev.evanishyn.entities.Employee;
import dev.evanishyn.services.EmployeeService;
import dev.evanishyn.services.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeServiceTest {

    EmployeeDAO employeeDAO = new EmployeeDAOLocal();
    EmployeeService employeeService = new EmployeeServiceImpl(employeeDAO);

    //Post
    @Test   //PASSED
    void create_employee_no_errors() {
        Employee testEmp = new Employee(0, "Caitlin", "Evanishyn");
        Employee savedEmployee = employeeService.registerEmployeeAccount(testEmp);
        Assertions.assertEquals(1, savedEmployee.getId());
    }

    @Test   //Fix the registerEmployeeAccount name verification
    void create_employee_some_errors() {
        Employee testEmp = new Employee(0, "C", "Evanishyn");
        Assertions.assertEquals("", employeeService.registerEmployeeAccount(testEmp).getfName());
//            Employee savedEmployee = employeeService.registerEmployeeAccount(testEmp);
//            Assertions.assertNotEquals(1, savedEmployee.getId());
    }

    //Get

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

        //Patch

        //Delete





}
