package dev.evanishyn.serviceTests;

import dev.evanishyn.daos.expenses_daos.ExpenseDAO;
import dev.evanishyn.daos.expenses_daos.ExpenseDAOlocal;
import dev.evanishyn.entities.Employee;
import dev.evanishyn.entities.Expense;
import dev.evanishyn.services.ExpenseService;
import dev.evanishyn.services.ExpenseServiceImpl;
import dev.evanishyn.utilities.Category;
import dev.evanishyn.utilities.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpenseServiceTests {

    ExpenseDAO expenseDAO = new ExpenseDAOlocal();
    ExpenseService expenseService = new ExpenseServiceImpl(expenseDAO);

    //Post
    @Test
    void create_claim_no_errors() {
        Expense newClaim = new Expense(0, 1, 100.00, "The Four Seasons", Category.LODGING, Status.PENDING);
        Expense savedClaim = expenseDAO.createClaim(newClaim);
        Assertions.assertEquals(1, savedClaim.getId());
    }
    //Get

    //Put

    //Patch

    //Delete
}
