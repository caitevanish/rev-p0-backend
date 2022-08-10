package dev.evanishyn.services;

import dev.evanishyn.entities.Expense;
import dev.evanishyn.utilities.Status;

import java.util.Map;

public interface ExpenseService {

    //-----------POST-----------
    Expense createNewClaimService(Expense expense);


    //----------GET [x3]----------
    // 1] get expense report (aka all expense claims)
    Map<Integer,Expense> getAllClaims();

    // 2] get all pending claim reimbursements
    Map<Integer,Expense> getPendingClaims(Status status);

    // 3] get claims by id
    Expense getClaimById(int id);


    //-----put-----
    Expense updateClaimInformation(Expense expense);


//    //-----patch [x2]-----
//    // 1] approve
//    Expense updateApproveClaim();
//    // 2] deny
//    Expense updateDenyClaim();

    Expense updateClaimsStatus(Expense expense);


    //-----delete-----
    boolean deleteClaimById(int id);


}
