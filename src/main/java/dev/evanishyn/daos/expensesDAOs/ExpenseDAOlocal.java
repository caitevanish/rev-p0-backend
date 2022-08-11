package dev.evanishyn.daos.expensesDAOs;


import dev.evanishyn.entities.Expense;
import dev.evanishyn.utilities.Status;

import java.util.HashMap;
import java.util.Map;

public class ExpenseDAOlocal implements ExpenseDAO{

    ExpenseDAO expenseDAO;
    private Map<Integer, Expense> expenseTable = new HashMap<>();
    private int idMaker = 1;

    //-----------POST-----------
    @Override
    public Expense createClaim(Expense expense) {
        expense.setExp_id(idMaker);
        idMaker++;
        expenseTable.put(expense.getExp_id(), expense);
        System.out.println(expense);
        return expense;
    }



    //-----------GET-----------
    // 1] get expense report (aka all expense claims)
    @Override
    public Map<Integer,Expense> getAllClaims(){
        return expenseTable;
    }


    // 2] get all pending claim reimbursements
    @Override
    public Map<Integer,Expense> getPendingClaims(Status status){
        Map<Integer, Expense> allClaims = this.getAllClaims();
        Map<Integer, Expense> pendingClaims = new HashMap<>();

        for(Expense expense : allClaims.values()){
            if(expense.getStatus().equals(status.PENDING)){
                pendingClaims.put(expense.getExp_id(), expense);
            }
        }
        return pendingClaims;
    }

    // 3] get claims by id
    @Override
    public Expense getClaimById(int id){
        return expenseTable.get(id);
    }


    //-----------PUT-----------
    // update expense
    @Override
    public Expense updateClaimInformation(Expense expense){
        expenseTable.put(expense.getExp_id(), expense);
        return expense;
    }

    //-----------PATCH-----------
    // 1] approve
    // 2] deny

    @Override
    public Expense updateClaimsStatus(Expense expense, Status status){

    Expense pendingExp = expenseTable.get(expense.getExp_id());
    String newStatus = pendingExp.getStatus().toString();

        if (expenseTable.get(pendingExp).equals(null))
    {
        System.out.println("Expense id " + pendingExp.getExp_id() + " not found");
        return null;

    }else if (pendingExp.getStatus() == Status.APPROVED || pendingExp.getStatus() == Status.DENIED)
    {
        System.out.println("Cannot edit expense status");
        return null;

    } else if (pendingExp.getStatus() == Status.PENDING){
            pendingExp.setStatus(Status.valueOf(newStatus));
        return pendingExp;
    } else
    {
        System.out.println("invalid status input");
    }
        return null;
}


    //-----------DELETE-----------
    @Override
    public boolean deleteClaimById(int id){
        Expense expense = expenseTable.remove(id);
        return expense != null;
    }


    //===================================
    //-----------Nested Routes-----------
    //===================================


    //-----post-----
    // returns expenses for employee 120



    //-----get-----
    //adds an expense to employee 120

}

