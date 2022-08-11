package dev.evanishyn.handlers.expenseHandlers;

import com.google.gson.Gson;
import dev.evanishyn.app.App;
import dev.evanishyn.entities.Expense;
import dev.evanishyn.utilities.Status;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import kotlin.jvm.Throws;
import org.jetbrains.annotations.NotNull;

public class UpdateClaimStatusHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception{
        int expId = Integer.parseInt(ctx.pathParam("id"));
        String status = ctx.pathParam("status");

        Gson gson = new Gson();
        Expense expense = App.expenseService.getClaimById(expId);
        String json = gson.toJson(expense);

        if(expense != null) {
            if (expense.getStatus().name().equals("PENDING")) {   //Case sens?
                if(status.equals("approve")){
                        expense = App.expenseService.updateClaimsStatus(expense, Status.APPROVED);
                        String newJson = gson.toJson(expense);
                        System.out.println("Expense is updated");   //checking status parameter
                        ctx.status(200);
                        ctx.result("Expense has been approved: \n" + newJson);
                        System.out.println("CASE: approve..." + expense.getStatus().toString());

                } else if(status.equals("deny")){
                        App.expenseService.updateClaimsStatus(expense, Status.DENIED);
                        ctx.status(200);
                        ctx.result("Expense has been denied");
                        System.out.println("CASE: deny..." + expense.getStatus().toString());

                } else{
                        ctx.status(400);
                        ctx.result("Input incorrect route name");
                        System.out.println("CASE: Nope..." + expense.getStatus().toString());
                }
            }
            else{
                ctx.status(422);
                ctx.result("Expense can't be updated. Already approved/denied.");
            }
        } else{
            ctx.status(404);
            ctx.result("Expense not updated, or even found.");
        }
    }
}
