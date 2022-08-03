package dev.evanishyn.handlers.expense_handlers;

import dev.evanishyn.app.App;
import dev.evanishyn.entities.Expense;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class DeleteClaimByIdHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {

        int id = Integer.parseInt(ctx.pathParam("id"));
        boolean result = App.expenseService.deleteClaimById(id);
        if (result) {
            ctx.status(204);
            ctx.result("The claim has been deleted");
//        } else if(){
//
        }
        else{
                ctx.status(404);
                ctx.result("Expense claim not found");
            }
        }
    }