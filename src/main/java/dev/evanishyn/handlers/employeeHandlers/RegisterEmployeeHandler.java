package dev.evanishyn.handlers.employeeHandlers;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Employee;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class RegisterEmployeeHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception{
        String json = ctx.body();       //creates json object and fills with body(?)
        Gson gson = new Gson();         //Instantiate a gson object (converts to json)
        Employee employee = gson.fromJson(json, Employee.class);    //create employee object; json -> gson
//        Employee registeredEmployee = App.employeeService.registerEmployeeAccount(employee);    //create registered employee from app
        String employeeJson = gson.toJson(App.employeeService.registerEmployeeAccount(employee));  //create json string from regEmp info
        ctx.status(201);        //checking for a 201 status
        ctx.result(employeeJson);       //returning employee Json string to page

//        App.employeeList.add(registeredEmployee);

    }

//    public boolean containsIllegalSymbol(Employee employee){
//        Pattern pattern = Pattern.compile("[~#*+%{}<>\\[\\]|\"\\_^]");
//        Matcher matcher = pattern.matcher(employee.getEmail());
//        return matcher.find();
//    }

}
