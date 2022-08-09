package dev.evanishyn.handlers.expenseHandlers;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdateClaimById implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception{
        String expenseJSON = ctx.body();
        Gson gson = new Gson();
        Expense expense = gson.fromJson(expenseJSON, Expense.class);
        Expense updateExpense = App.expenseService.updateClaimInformation(expense);
        String json = gson.toJson(updateExpense);
        if(expense != null){
            ctx.result(json);
        }
        else{
            ctx.status(404);
            ctx.result("Expense not Found");
        }

    }
}
