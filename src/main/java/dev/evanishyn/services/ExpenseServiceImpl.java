package dev.evanishyn.services;

import dev.evanishyn.daos.expensesDAOs.ExpenseDAO;
import dev.evanishyn.entities.Expense;
import dev.evanishyn.utilities.Status;

import java.util.Map;



public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseDAO expenseDAO;


    public ExpenseServiceImpl(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    //-----------POST-----------
    @Override
    public Expense createNewClaimService(Expense expense) {
        if (expense.getExp_id() != 0 && expense.getEmployeeID() > 0) {   //Checks for an id
            if (expense.getAmount() <= 0 || expense.getDescription().length() == 0 || expense.getCategory() == null) {
                throw new RuntimeException("Make sure you have filled in all fields correctly");
            }
        }
                return this.expenseDAO.createClaim(expense);
    }


    //-----get [x3]-----
    // 1] get expense report (aka all expense claims)

    @Override
    public Map<Integer, Expense> getAllClaims(){
        return expenseDAO.getAllClaims();
    }

    // 2] get all pending claim reimbursements
    @Override
    public Map<Integer, Expense> getPendingClaims(Status status){
        return expenseDAO.getPendingClaims(status);
    }

    // 3] get claims by id
    @Override
    public Expense getClaimById(int id){
        return expenseDAO.getClaimById(id);
    }


    //-----put-----
    // update expense
    @Override
    public Expense updateClaimInformation(Expense expense){
        expense.setStatus(Status.PENDING);
        return this.expenseDAO.updateClaimInformation(expense);
    }

    //-----patch [x2]-----
    // 1] approve
    // 2] deny
    @Override
    public Expense updateClaimsStatus(Expense expense, Status status){
        return this.expenseDAO.updateClaimsStatus(expense, status);


//        return this.expenseDAO.getClaimById(expense.getExp_id());
//        if(pendingExpense != null){    //checks that there's an expense
////            if(expense.getStatus() == Status.PENDING){
////                if(status == Status.APPROVED){
////                    expense.setStatus(Status.APPROVED);
////                } else if(status == Status.DENIED){
////                    expense.setStatus(Status.DENIED);
////                }
////                return this.expenseDAO.updateClaimsStatus(pendingExpense.getExp_id(), pendingExpense.getStatus().toString());
//                return this.expenseDAO.updateClaimsStatus(pendingExpense.getExp_id(), pendingExpense.getStatus().toString());
//            }
//            return null;
        }


    //-----delete-----
    @Override
    public boolean deleteClaimById(int id){
        return this.expenseDAO.deleteClaimById(id);
    }

    //===================================
    //-----------Nested Routes-----------
    //===================================

    //-----post-----
    // returns expenses for employee 120



    //-----get-----
    //adds an expense to employee 120


}