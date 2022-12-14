package dev.evanishyn.serviceTests;

import dev.evanishyn.daos.expensesDAOs.ExpenseDAO;
import dev.evanishyn.daos.expensesDAOs.ExpenseDAOlocal;
import dev.evanishyn.entities.Expense;
import dev.evanishyn.services.ExpenseService;
import dev.evanishyn.services.ExpenseServiceImpl;
import dev.evanishyn.utilities.Category;
import dev.evanishyn.utilities.Status;
import org.junit.jupiter.api.*;

import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ExpenseServiceTests {

    static ExpenseDAO expenseDAO = new ExpenseDAOlocal();
    static ExpenseService expenseService = new ExpenseServiceImpl(expenseDAO);

    //Post
    @Test
    @Order(1)
    void create_claim_no_errors() {
        Expense newClaim = new Expense(0, 1, 100.00, "The Four Seasons", Category.LODGING, Status.PENDING);
        Expense savedClaim = expenseService.createNewClaimService(newClaim);
        Assertions.assertEquals(1, savedClaim.getExp_id());
    }
    //Get
    @Test
    @Order(2)
    void get_all_expenses_test(){
        Expense expense1 = new Expense(0,0, 50.00,"Red Lobster", Category.FOOD, Status.PENDING );
        Expense expense2 = new Expense(0,0, 300.00,"Airfare", Category.TRAVEL, Status.APPROVED );

        expenseService.createNewClaimService(expense1);
        expenseService.createNewClaimService(expense2);

        Map<Integer,Expense> expenseList = expenseService.getAllClaims();
        Assertions.assertEquals(3, expenseList.size());
    }

    @Test
    @Order(3)
    void get_expense_by_id_test(){
        Expense expense = expenseService.getClaimById(2);
        Assertions.assertEquals("Red Lobster", expense.getDescription());
    }

    @Test
    @Order(4)
    void get_all_pending_claims_test(){
        Expense expense3 = new Expense(0,2, 70.00,"Oregano's", Category.FOOD, Status.APPROVED );
        Expense expense4 = new Expense(0,2, 30.00,"Train ride", Category.TRAVEL, Status.PENDING );

        expenseDAO.createClaim(expense3);
        expenseDAO.createClaim(expense4);

        Map<Integer,Expense> pendingList = expenseDAO.getPendingClaims(Status.PENDING);

        Assertions.assertEquals(3, pendingList.size());
    }

    //Put
    @Test
    @Order(5)
    void update_expense_test(){    //
        Expense expense = new Expense(3, 1, 400.00, "Airfare", Category.TRAVEL, Status.PENDING);
        expenseService.updateClaimInformation(expense);
        Expense newExpense = expenseService.getClaimById(3);
        Assertions.assertEquals( 400.00, newExpense.getAmount());
    }

    //Patch

    //Delete
}
