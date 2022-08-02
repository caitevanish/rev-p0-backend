package dev.evanishyn.app;

import dev.evanishyn.daos.employee_daos.EmployeeDAOLocal;
import dev.evanishyn.daos.expenses_daos.ExpenseDAOlocal;
import dev.evanishyn.handlers.employee_handlers.DeleteEmployeeHandler;
import dev.evanishyn.handlers.employee_handlers.GetEmployeeByIdHandler;
import dev.evanishyn.handlers.employee_handlers.RegisterEmployeeHandler;
import dev.evanishyn.services.EmployeeService;
import dev.evanishyn.services.EmployeeServiceImpl;
import dev.evanishyn.services.ExpenseService;
import dev.evanishyn.services.ExpenseServiceImpl;
import io.javalin.Javalin;

public class App {

    public static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDAOLocal());
    public static ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDAOlocal());

//    public static List<Employee> employeeList = new ArrayList<>();


    public static void main(String[] args) {
        Javalin app = Javalin.create();
        //Add a 'try'-with statement



        //-----------Employee-----------
        RegisterEmployeeHandler registerEmployeeHandler = new RegisterEmployeeHandler();
        GetEmployeeByIdHandler getEmployeeByIdHandler = new GetEmployeeByIdHandler();
//        GetEmployeeListHandler getEmployeeListHandler = new GetEmployeeListHandler();
        //update
        DeleteEmployeeHandler deleteEmployeeHandler = new DeleteEmployeeHandler();


        app.post("/employee", registerEmployeeHandler);
        app.get("/employee/{id}", getEmployeeByIdHandler);
//        app.get("/employees", getEmployeeListHandler);
        //update
        app.delete("/employee/{id}", deleteEmployeeHandler);


        //-----------Expense-----------






        app.start();
    }

}
