package dev.evanishyn.handlers.expenseHandlers;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;



public class CreateNewClaimHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception{
        String json = ctx.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(json, Expense.class);
        Expense newClaim = App.expenseService.createNewClaimService(expense);
        String expenseJson = gson.toJson(newClaim);
        ctx.status(201);
        ctx.result(expenseJson);
    }

}
