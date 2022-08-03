package dev.evanishyn.services;

import dev.evanishyn.entities.Expense;

import java.util.Map;

public interface ExpenseService {

    //-----------POST-----------
    Expense createNewClaimService(Expense expense);


    //-----get [x3]-----
    // 1] get expense report (aka all expense claims)
    Expense getAllClaimsService();

    // 2] get all pending claim reimbursements
    Map<Integer,Expense> getPendingClaims();

    // 3] get claims by id
    Map<Integer,Expense> getAllClaims();


    //-----put-----
    // update expense
    Expense updateClaimInformation(Expense expense);


    //-----patch [x2]-----
    // 1] approve
    Expense updateApproveClaim();


    // 2] deny
    Expense updateDenyClaim();



    //-----delete-----
    boolean deleteClaimById(int id);


}
