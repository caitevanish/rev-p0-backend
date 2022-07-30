package dev.evanishyn.app;

import dev.evanishyn.daos.EmployeeDAO;
import dev.evanishyn.daos.EmployeeDAOLocal;
import dev.evanishyn.entities.Employee;
import dev.evanishyn.handlers.RegisterEmployeeHandler;
import dev.evanishyn.services.EmployeeService;
import dev.evanishyn.services.EmployeeServiceImpl;
import io.javalin.Javalin;

public class App {

    public static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDAOLocal());

    public static void main(String[] args) {
        Javalin app = Javalin.create();


        RegisterEmployeeHandler registerEmployeeHandler = new RegisterEmployeeHandler();


        app.post("/register-employee", registerEmployeeHandler);




        app.start();
    }

}
