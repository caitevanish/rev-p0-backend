package dev.evanishyn.daoTests;

import dev.evanishyn.daos.expensesDAOs.ExpenseDAO;
import dev.evanishyn.daos.expensesDAOs.ExpenseDAOPostgres;
import dev.evanishyn.entities.Expense;
import dev.evanishyn.utilities.ConnectionUtil;
import dev.evanishyn.utilities.Status;
import dev.evanishyn.utilities.Category;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ExpenseDAOtests {

    @BeforeAll  //Passed
    static void setup(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "create table expense(\n" +
                    "\texp_id serial primary key,\n" +
                    "\tamount int,\n" +
                    "\tdescription varchar(200) not null,\n" +
//                    "\tcategory varchar(10) not null,\n" +
                    "\tcategory varchar(40) check (category in ('LODGING', 'TRAVEL', 'FOOD', 'OTHER')),\n" +
//                    "\tstatus varchar(10) not null,\n" +
                    "\tstatus varchar(10) check (status in ('PENDING', 'APPROVED', 'DENIED')),\n" +
                    "\te_id int references employee(emp_id)\n" +
                    ")";
            Statement s = conn.createStatement();
            s.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

//    @AfterAll
//    static void teardown(){
//        try(Connection conn = ConnectionUtil.createConnection()){
//            String sql = "drop table expense";
//            Statement s = conn.createStatement();
//            s.execute(sql);
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }

    static ExpenseDAO expenseDAO = new ExpenseDAOPostgres();


    @Test   //PASSED
    @Order(1)
    void create_expense_dao_test_1(){
        Expense newClaim = new Expense(0, 1, 100.00, "The Four Seasons", Category.LODGING, Status.PENDING );
        Expense savedClaim = expenseDAO.createClaim(newClaim);
        Assertions.assertEquals(1, savedClaim.getExp_id());
    }

    //Get
    @Test   //PASSED
    @Order(2)
    void get_all_expenses_test(){
        Expense expense1 = new Expense(0,1, 50.00,"Red Lobster", Category.FOOD, Status.PENDING );
        Expense expense2 = new Expense(0,1, 300.00,"Airfare", Category.TRAVEL, Status.APPROVED );

        expenseDAO.createClaim(expense1);
        expenseDAO.createClaim(expense2);

        Map<Integer,Expense> expenseList = expenseDAO.getAllClaims();
        Assertions.assertEquals(3, expenseList.size());
    }

    @Test   //Passed
    @Order(3)
    void get_expense_by_id(){
        Expense expense = expenseDAO.getClaimById(2);
        Assertions.assertEquals("Red Lobster", expense.getDescription());
    }

    @Test
    @Order(4)
    void get_pending_claims_list(){
        Expense expense3 = new Expense(0,2, 70.00,"Oregano's", Category.FOOD, Status.APPROVED );
        Expense expense4 = new Expense(0,2, 36.00,"Train", Category.TRAVEL, Status.PENDING );

        expenseDAO.createClaim(expense3);
        expenseDAO.createClaim(expense4);

        Map<Integer,Expense> pendingList = expenseDAO.getPendingClaims(Status.PENDING);
//        Map<Integer,Expense> pendingList = expenseDAO.getPendingClaims();

        for(Map.Entry<Integer, Expense> e :  pendingList.entrySet())
            System.out.println("Key = " + e.getKey() + ", Value = " + e.getValue());

        Map<Integer,Expense> expenseList = expenseDAO.getAllClaims();
        for(Map.Entry<Integer, Expense> e :  expenseList.entrySet())
            System.out.println("Key = " + e.getKey() + ", Value = " + e.getValue());


        Assertions.assertEquals(3, pendingList.size());
    }


    //Put
    @Test
    @Order(5)
    void update_expense_test(){    //
        Expense updExpense = expenseDAO.getClaimById(1);
        updExpense.setAmount(1000.00);
        expenseDAO.updateClaimInformation(updExpense);
        Assertions.assertNotEquals( 100.00, updExpense.getAmount());
    }

//    Delete
    @Test   //PASSED
    @Order(6)
    void delete_expense_test(){
        boolean result = expenseDAO.deleteClaimById(1);
        Assertions.assertTrue(result);
    }

}
