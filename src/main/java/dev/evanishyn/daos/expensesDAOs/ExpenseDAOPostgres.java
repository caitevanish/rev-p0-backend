package dev.evanishyn.daos.expensesDAOs;

import dev.evanishyn.entities.Employee;
import dev.evanishyn.entities.Expense;
import dev.evanishyn.utilities.Category;
import dev.evanishyn.utilities.ConnectionUtil;
import dev.evanishyn.utilities.Status;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ExpenseDAOPostgres implements ExpenseDAO{

    @Override
    public Expense createClaim(Expense expense) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into expense values (default, ? , ?, ?, ?, ?) ";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setDouble(1, expense.getAmount());
            ps.setString(2, expense.getDescription());
            ps.setString(3, expense.getCategory().toString());
            ps.setString(4, expense.getStatus().toString());
            ps.setInt(5, expense.getEmployeeID());

//            ps.setInt(1, expense.getEmployeeID());
//            ps.setDouble(1, expense.getAmount());
//            ps.setString(2, expense.getDescription());
//            ps.setString(3, "OTHER");
//            ps.setString(4, "PENDING");

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int generateKey = rs.getInt("exp_id");
            expense.setExp_id(generateKey);
            return expense;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<Integer, Expense> getAllClaims() {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from expense";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Map<Integer, Expense> expenseList = new HashMap<>();

            while(rs.next()){
                Expense expense = new Expense();
                Employee employee = new Employee();
                expense.setExp_id(rs.getInt("exp_id"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setDescription(rs.getString("description"));
                expense.setStatus(rs.getString("status"));


                //trainwreck!
//                expense.setCategory(Category.valueOf(rs.getString(expense.getCategory().toString())));
//                expense.setStatus.toString(rs.getString("status"));
                expense.setCategory(Status.valueOf());
//                expense.setStatus(Status.valueOf(rs.getString(expense.getStatus().toString())));
                employee.setEmp_id(rs.getInt("e_id"));
                expenseList.put(expense.getExp_id(), expense);
            }
            return expenseList;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public Map<Integer, Expense> getPendingClaims(Status status) {
        try(Connection conn = ConnectionUtil.createConnection()){


        }catch(SQLException e){
            e.printStackTrace();
        }
            return null;
    }

    @Override
    public Expense getClaimById(int id) {
        try(Connection conn = ConnectionUtil.createConnection()){


        }catch(SQLException e){
            e.printStackTrace();
        }
            return null;
    }
    @Override
    public Expense updateClaimInformation(Expense expense) {
        try(Connection conn = ConnectionUtil.createConnection()){


        }catch(SQLException e){
            e.printStackTrace();
        }
            return null;
    }

    @Override
    public boolean deleteClaimById(int id) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "delete from expense where exp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
