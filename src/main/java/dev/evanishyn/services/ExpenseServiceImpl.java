package dev.evanishyn.services;

import dev.evanishyn.daos.expenses_daos.ExpenseDAO;
import dev.evanishyn.entities.Expense;

public class ExpenseServiceImpl implements ExpenseService{

    private ExpenseDAO expenseDAO;
    public ExpenseServiceImpl(ExpenseDAO expenseDAO){
        this.expenseDAO = expenseDAO;
    }

    //-----------POST-----------
    @Override
    public Expense createNewClaimService(Expense expense) {
        return null;
    }

    //-----get [x3]-----
    // 1] get expense report (aka all expense claims)
    @Override
    public Expense getAllClaimsService(){
        return null;
    }

    // 2] get all pending claim reimbursements
    // 3] get claims by id




    //-----put-----
    // update expense



    //-----patch [x2]-----
    // 1] approve
    // 2] deny



    //-----delete-----
}
