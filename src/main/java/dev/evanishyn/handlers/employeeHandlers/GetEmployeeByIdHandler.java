package dev.evanishyn.handlers.employeeHandlers;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Employee;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetEmployeeByIdHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception{
        int id = Integer.parseInt(ctx.pathParam("id"));
        Employee employee = App.employeeService.getEmployeeById(id);
        Gson gson = new Gson();
        String json = gson.toJson(employee);

        if(employee != null){
            ctx.result(json);
        }
        else{
            ctx.status(404);
            ctx.result("Employee not Found");
        }

    }

}
