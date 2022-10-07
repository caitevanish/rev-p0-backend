package dev.evanishyn.services;

import dev.evanishyn.entities.Expense;
import dev.evanishyn.utilities.Status;

import java.util.List;
import java.util.Map;

public interface ExpenseService {

    //-----------POST-----------
    Expense createNewClaimService(Expense expense);


    //----------GET [x3]----------
    // 1] get expense report (aka all expense claims)
    List<Expense> getAllClaims();

    // 2] get all pending claim reimbursements
    List<Expense> getPendingClaims(Status status);

    // 3] get claims by id
    Expense getClaimById(int id);


    //-----put-----
    Expense updateClaimInformation(Expense expense);


     //-----patch [x2]-----
    // 1] approve
    // 2] deny
    Expense updateClaimsStatus(Expense expense, Status status);


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
