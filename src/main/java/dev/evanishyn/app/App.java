package dev.evanishyn.app;

import dev.evanishyn.daos.employee_daos.EmployeeDAOLocal;
import dev.evanishyn.daos.expenses_daos.ExpenseDAOlocal;
import dev.evanishyn.handlers.employee_handlers.*;
import dev.evanishyn.handlers.expense_handlers.CreateNewClaimHandler;
import dev.evanishyn.services.EmployeeService;
import dev.evanishyn.services.EmployeeServiceImpl;
import dev.evanishyn.services.ExpenseService;
import dev.evanishyn.services.ExpenseServiceImpl;
import io.javalin.Javalin;

public class App {

    public static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDAOLocal());
    public static ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDAOlocal());


    public static void main(String[] args) {
        Javalin app = Javalin.create();
        //Add a 'try'-with statement


        //-----------Employee-----------
        RegisterEmployeeHandler registerEmployeeHandler = new RegisterEmployeeHandler();
        GetEmployeeByIdHandler getEmployeeByIdHandler = new GetEmployeeByIdHandler();
        GetEmployeeListHandler getEmployeeListHandler = new GetEmployeeListHandler();
        UpdateEmployeeHandler updateEmployeeHandler = new UpdateEmployeeHandler();
        DeleteEmployeeHandler deleteEmployeeHandler = new DeleteEmployeeHandler();

        app.post("/employee", registerEmployeeHandler);
        app.get("/employee/{id}", getEmployeeByIdHandler);
        app.get("/employees", getEmployeeListHandler);
        app.put("/employee", updateEmployeeHandler);
        app.delete("/employee/{id}", deleteEmployeeHandler);


        //-----------Expense-----------
        CreateNewClaimHandler createNewClaimHandler = new CreateNewClaimHandler();


        app.post("/expenses", createNewClaimHandler);



        app.start();
    }

}
