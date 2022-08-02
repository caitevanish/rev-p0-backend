package dev.evanishyn.daos.expenses_daos;

import dev.evanishyn.daos.employee_daos.EmployeeDAO;
import dev.evanishyn.daos.employee_daos.EmployeeDAOLocal;
import dev.evanishyn.entities.Employee;
import dev.evanishyn.entities.Expense;

import java.util.HashMap;
import java.util.Map;

public class ExpenseDAOlocal implements ExpenseDAO{

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
        return this.expenseTable;
    }


    // 2] get all pending claim reimbursements
    @Override
    public Expense getPendingClaims(){
        return null;
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

