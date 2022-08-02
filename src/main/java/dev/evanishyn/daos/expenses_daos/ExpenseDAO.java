package dev.evanishyn.daos.expenses_daos;

import dev.evanishyn.entities.Expense;

public interface ExpenseDAO {


    //-----post-----
    // create new expense claim
    Expense createClaim(Expense expense);




    //-----get [x3]-----
    // 1] get expense report (aka all expense claims)
    // 2] get all pending claim reimbursements
    // 3] get claims by id



    //-----put-----
    // update expense



    //-----patch [x2]-----
    // 1] approve
    // 2] deny



    //-----delete-----




    //===================================
    //-----------Nested Routes-----------
    //===================================

    //-----post-----
    // returns expenses for employee 120


    //-----get-----
    //adds an expense to employee 120


}
