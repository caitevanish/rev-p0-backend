package dev.evanishyn.daos.expenses_daos;

import dev.evanishyn.entities.Expense;
import dev.evanishyn.utilities.Status;

import java.util.Map;

public interface ExpenseDAO {


    //-----post-----
    // create new expense claim
    Expense createClaim(Expense expense);


    //-----get [x3]-----
    // 1] get expense report (aka all expense claims)
    Map<Integer,Expense> getAllClaims();


//    // 2] get all pending claim reimbursements
//    Map<Integer,Expense> getPendingClaims(Status status);


    // 2] get all pending claim reimbursements
    Map<Integer,Expense> getPendingClaims(Status status);

    // 3] get claims by id
    Expense getClaimById(int id);



    //-----put-----
    // update expense
    Expense updateClaimInformation(Expense expense);


//    //-----patch [x2]-----
//    // 1] approve
//    Expense updateApproveClaim();
//
//    // 2] deny
//    Expense updateDenyClaim();



    //-----delete-----
    boolean deleteClaimById(int id);




    //===================================
    //-----------Nested Routes-----------
    //===================================

    //-----post-----
    // returns expenses for employee 120


    //-----get-----
    //adds an expense to employee 120


}
