package dev.evanishyn.handlers.employeeHandlers;

import dev.evanishyn.app.App;
import dev.evanishyn.entities.Employee;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class DeleteEmployeeHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception{
        int id = Integer.parseInt(ctx.pathParam("emp_id"));
        Employee employee =App.employeeService.getEmployeeById(id);
        if(employee == null){
            ctx.status(404);
            ctx.result("Employee not found");
        } else {
            App.employeeService.deleteEmployeeAccount(id);
            ctx.status(204);
            ctx.result("Employee has been deleted");
        }
    }
}
