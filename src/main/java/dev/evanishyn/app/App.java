package dev.evanishyn.app;

import dev.evanishyn.daos.employeeDAOs.EmployeeDAOLocal;
import dev.evanishyn.daos.employeeDAOs.EmployeeDAOPostgres;
import dev.evanishyn.daos.expensesDAOs.ExpenseDAOPostgres;
import dev.evanishyn.daos.expensesDAOs.ExpenseDAOlocal;
import dev.evanishyn.handlers.employeeHandlers.*;
import dev.evanishyn.handlers.expenseHandlers.*;
import dev.evanishyn.services.EmployeeService;
import dev.evanishyn.services.EmployeeServiceImpl;
import dev.evanishyn.services.ExpenseService;
import dev.evanishyn.services.ExpenseServiceImpl;
import io.javalin.Javalin;

public class App {

    public static EmployeeService employeeService = new EmployeeServiceImpl(new EmployeeDAOPostgres());
    public static ExpenseService expenseService = new ExpenseServiceImpl(new ExpenseDAOPostgres());


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
        GetClaimByIdHandler getClaimByIdHandler = new GetClaimByIdHandler();
        GetAllClaimsHandler getAllClaimsHandler = new GetAllClaimsHandler();
        GetPendingClaimsHandler getPendingClaimsHandler = new GetPendingClaimsHandler();
        UpdateClaimByIdHandler updateClaimByIdHandler = new UpdateClaimByIdHandler();
        UpdateClaimStatusHandler updateClaimStatusHandler = new UpdateClaimStatusHandler();
        DeleteClaimByIdHandler deleteClaimByIdHandler = new DeleteClaimByIdHandler();

        app.post("/expenses", createNewClaimHandler);
        app.get("/expenses/{id}", getClaimByIdHandler);
        app.get("/expenses", getAllClaimsHandler);
        app.get("/expenses?status={status}", getPendingClaimsHandler);
        app.put("/expenses/{id}", updateClaimByIdHandler);
        app.patch("/expenses/{id}/{status}", updateClaimStatusHandler);
        app.delete("/expenses/{id}", deleteClaimByIdHandler);


        app.start();
    }

}
