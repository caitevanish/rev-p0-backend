package dev.evanishyn.daos.expenses_daos;


import dev.evanishyn.entities.Expense;

import java.util.HashMap;
import java.util.Map;

public class ExpenseDAOlocal implements ExpenseDAO{

    ExpenseDAO expenseDAO;
    private Map<Integer, Expense> expenseTable = new HashMap<>();
    private int idMaker = 1;

    //-----------POST-----------
    @Override
    public Expense createClaim(Expense expense) {
        expense.setId(idMaker);
        idMaker++;
        expenseTable.put(expense.getId(), expense);
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
    public Map<Integer,Expense> getPendingClaims(){
        return null;
    }

    // 3] get claims by id
    @Override
    public Expense getClaimById(int id){
        return this.expenseDAO.getClaimById(id);
    }

    //-----------PUT-----------
    // update expense
    @Override
    public Expense updateClaimInformation(Expense expense){
        expenseTable.put(expense.getId(), expense);
        return expense;
    }

    //-----------PATCH-----------
    // 1] approve
    // 2] deny


    //-----------DELETE-----------
    @Override
    public boolean deleteClaimById(int id){
        Expense expense = expenseTable.remove(id);
        return expense != null;
    }

}

