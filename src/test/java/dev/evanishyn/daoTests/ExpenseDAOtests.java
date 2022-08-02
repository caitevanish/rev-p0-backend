package dev.evanishyn.daoTests;

import dev.evanishyn.daos.employee_daos.EmployeeDAOLocal;
import dev.evanishyn.daos.expenses_daos.ExpenseDAO;
import dev.evanishyn.daos.expenses_daos.ExpenseDAOlocal;
import dev.evanishyn.entities.Employee;
import dev.evanishyn.entities.Expense;
import dev.evanishyn.services.EmployeeService;
import dev.evanishyn.services.EmployeeServiceImpl;
import dev.evanishyn.utilities.Status;
import dev.evanishyn.utilities.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpenseDAOtests {

    ExpenseDAO expenseDAO = new ExpenseDAOlocal();


//    @Test
//    void create_expense_dao_test_1(){
//        Expense newClaim = new Expense(0, new Employee(0, "Fancy", "Person"), 100.00, "The Four Seasons", Type.LODGING, Status.PENDING );
//        Expense savedClaim = expenseDAO.createClaim(newClaim);
//        Assertions.assertEquals();
//    }

}
