package dev.evanishyn.handlers.employeeHandlers;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Employee;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class GetEmployeeListHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception{
        Map<Integer,Employee> employeeList = App.employeeService.getEmployeeList();
        Gson gson = new Gson();
        String json = gson.toJson(employeeList);
        ctx.result(json);
    }


}
