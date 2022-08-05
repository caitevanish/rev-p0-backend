package dev.evanishyn.handlers.expenseHandlers;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Expense;
import dev.evanishyn.utilities.Status;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class GetPendingClaimsHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception{

        Map<Integer,Expense> pendingList= App.expenseService.getPendingClaims(Status.PENDING);

        Gson gson = new Gson();
        String json = gson.toJson(pendingList);
        ctx.result(json);


    }



}
