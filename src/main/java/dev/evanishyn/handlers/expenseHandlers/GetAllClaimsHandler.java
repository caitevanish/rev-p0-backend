package dev.evanishyn.handlers.expenseHandlers;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;


public class GetAllClaimsHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws  Exception{
        List<Expense> expenseList = App.expenseService.getAllClaims();
        Gson gson = new Gson();
        String json = gson.toJson(expenseList);
        ctx.result(json);

    }

}
