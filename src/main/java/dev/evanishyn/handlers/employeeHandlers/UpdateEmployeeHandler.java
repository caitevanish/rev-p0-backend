package dev.evanishyn.handlers.employeeHandlers;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Employee;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateEmployeeHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception{
        String employeeJSON = ctx.body();
        Gson gson = new Gson();
        Employee employee = gson.fromJson(employeeJSON, Employee.class);
        Employee updatedEmployee = App.employeeService.updateEmployeeInfo(employee);
        String json = gson.toJson(updatedEmployee);
        if(employee != null){
            ctx.result(json);
        }
        else{
            ctx.status(404);
            ctx.result("Employee not Found");
        }
    }
}
