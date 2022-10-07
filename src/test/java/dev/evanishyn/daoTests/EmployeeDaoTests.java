package dev.evanishyn.daoTests;

import dev.evanishyn.daos.employeeDAOs.EmployeeDAO;
import dev.evanishyn.daos.employeeDAOs.EmployeeDAOPostgres;
import dev.evanishyn.entities.Employee;
import dev.evanishyn.utilities.ConnectionUtil;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class EmployeeDaoTests {

    @BeforeAll
    static void teardown(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "drop table employee";
            Statement statement = conn.createStatement();
            statement.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @BeforeAll
    static void setup(){
        try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "create table employee(" +
                    "emp_id serial primary key,\n" +
                    "fname varchar(100) not null,\n" +
                    "lname varchar(100) not null);";
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }


//    @AfterAll


    static EmployeeDAO employeeDao = new EmployeeDAOPostgres();


    //Post
    @Test   //Passed
    @Order(1)
    void create_employee_test(){
        Employee employee = new Employee(0, "Caitlin", "Evanishyn");
        Employee savedEmployee = employeeDao.createEmployee(employee);
        Assertions.assertNotEquals(0, savedEmployee.getEmp_id());
    }

    //Get
    @Test   //PASSED
    @Order(2)
    void get_all_employees_test(){
        Employee employee1 = new Employee(0, "Moira", "Rose");
        Employee employee2 = new Employee(0, "David", "Rose");
        Employee employee3 = new Employee(0, "Johnny", "Rose");

        employeeDao.createEmployee(employee1);
        employeeDao.createEmployee(employee2);
        employeeDao.createEmployee(employee3);

        List<Employee> employeeList = employeeDao.getEmployeeList();

        Assertions.assertEquals(4,employeeList.size());
    }

    @Test   //Passed
    @Order(3)
    void get_employee_by_id(){
        Employee employee = employeeDao.getEmployeeById(1);
        Assertions.assertEquals("Caitlin", employee.getfName());

    }

    //Put
    @Test
    @Order(4)
    void update_employee_test(){
        Employee employee = new Employee(1, "Daniel", "Troup");
        employeeDao.updateEmployeeInfo(employee);
        Employee freshEmployee = employeeDao.getEmployeeById(1);
        Assertions.assertEquals( "Daniel", freshEmployee.getfName());
    }

    //Delete
    @Disabled
    @Test
    @Order(5)
    void delete_employee_test(){
        boolean result = employeeDao.deleteEmployeeAccount(1);
        Assertions.assertTrue(result);
    }


}
