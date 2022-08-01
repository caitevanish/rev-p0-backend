package dev.evanishyn.app;

import dev.evanishyn.daos.employee_daos.EmployeeDAOLocal;
import dev.evanishyn.entities.Employee;
import dev.evanishyn.handlers.DeleteEmployeeHandler;
import dev.evanishyn.handlers.GetEmployeeByIdHandler;
import dev.evanishyn.handlers.GetEmployeeListHandler;
import dev.evanishyn.handlers.RegisterEmployeeHandler;
import dev.evanishyn.services.EmployeeService;
import dev.evanishyn.services.EmployeeServiceImpl;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDAOLocal());

//    public static List<Employee> employeeList = new ArrayList<>();


    public static void main(String[] args) {
        Javalin app = Javalin.create();
        //Add a 'try'-with statement


        RegisterEmployeeHandler registerEmployeeHandler = new RegisterEmployeeHandler();
        GetEmployeeByIdHandler getEmployeeByIdHandler = new GetEmployeeByIdHandler();
//        GetEmployeeListHandler getEmployeeListHandler = new GetEmployeeListHandler();
        //update
        DeleteEmployeeHandler deleteEmployeeHandler = new DeleteEmployeeHandler();


        app.post("/registeremployee", registerEmployeeHandler);
        app.get("/employee/{id}", getEmployeeByIdHandler);
//        app.get("/employees", getEmployeeListHandler);
        //update
        app.delete("/employee/{id}", deleteEmployeeHandler);





        app.start();
    }

}
