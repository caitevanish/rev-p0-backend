package dev.evanishyn.services;

import dev.evanishyn.entities.Expense;
import dev.evanishyn.utilities.Status;

import java.util.Map;

public interface ExpenseService {

    //-----------POST-----------
    Expense createNewClaimService(Expense expense);


//    // 2] get all pending claim reimbursements
//    Map<Integer, Expense> getPendingClaims(Status status);

    //-----get [x3]-----
    // 1] get expense report (aka all expense claims)
    Expense getClaimById(int id);

//    // 2] get all pending claim reimbursements
//    Map<Integer,Expense> getPendingClaims();

    // 3] get claims by id
    Map<Integer,Expense> getAllClaims();


    //-----put-----
    // update expense
    Expense updateClaimInformation(Expense expense);


//    //-----patch [x2]-----
//    // 1] approve
//    Expense updateApproveClaim();
//
//
//    // 2] deny
//    Expense updateDenyClaim();



    //-----delete-----
    boolean deleteClaimById(int id);


}
