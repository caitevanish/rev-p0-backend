package dev.evanishyn.daos.expenses_daos;

import dev.evanishyn.daos.employee_daos.EmployeeDAO;
import dev.evanishyn.daos.employee_daos.EmployeeDAOLocal;
import dev.evanishyn.entities.Employee;
import dev.evanishyn.entities.Expense;

import java.util.HashMap;
import java.util.Map;

public class ExpenseDAOlocal implements ExpenseDAO{

    private Map<Integer, Expense> expenseMap = new HashMap<>();
    private EmployeeDAO employeeDAO = new EmployeeDAOLocal();
    private int idMaker = 1;

    //-----------POST-----------
    @Override
    public Expense createClaim(Expense expense) {
        expense.setId(idMaker);
        idMaker++;
        expenseMap.put(expense.getId(), expense);
        System.out.println(expense);
        return expense;
    }

    //-----------GET-----------

    //-----------PUT-----------

    //-----------PATCH-----------

    //-----------DELETE-----------

}

