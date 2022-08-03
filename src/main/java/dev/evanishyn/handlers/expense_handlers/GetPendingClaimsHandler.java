package dev.evanishyn.handlers.expense_handlers;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetPendingClaimsHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception{

//        Expense expense = App.expenseService.getPendingClaims();
//        Gson gson = new Gson();
//        String json = gson.toJson(expense);
//        ctx.result(json);


    }



}
