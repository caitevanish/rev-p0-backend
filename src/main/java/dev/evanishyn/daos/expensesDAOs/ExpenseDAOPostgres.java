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
            ps.setString(4, Status.PENDING.toString());
            ps.setInt(5, expense.getEmployeeID());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int generateKey = rs.getInt("exp_id");
            expense.setExp_id(generateKey);
            expense.setStatus(Status.PENDING);
            return expense;

        }catch(SQLException e){
            e.printStackTrace();
        return null;
        }
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
                expense.setExp_id(rs.getInt("exp_id"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setDescription(rs.getString("description"));
                expense.setStatus(Status.valueOf(rs.getString("status")));
                expense.setCategory(Category.valueOf(rs.getString("category")));
                expense.setEmployeeID(rs.getInt("e_id"));
                expenseList.put(expense.getExp_id(), expense );
            }
            return expenseList;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Expense getClaimById(int id) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from expense where expense.exp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Expense expense = new Expense();
            expense.setExp_id(rs.getInt("exp_id"));
            expense.setAmount(rs.getDouble("amount"));
            expense.setDescription(rs.getString("description"));
            expense.setStatus(Status.valueOf(rs.getString("status")));
            expense.setCategory(Category.valueOf(rs.getString("category")));

            return expense;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<Integer, Expense> getPendingClaims(Status status) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "Select * from expense where expense.status = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "PENDING");

            ResultSet rs = ps.executeQuery();

            Map<Integer, Expense> expenseList = new HashMap<>();

            while(rs.next()){
                Expense expense = new Expense();
                expense.setExp_id(rs.getInt("exp_id"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setDescription(rs.getString("description"));
                expense.setStatus(Status.valueOf(rs.getString("status")));
                expense.setCategory(Category.valueOf(rs.getString("category")));
                expense.setEmployeeID(rs.getInt("e_id"));
                expenseList.put(expense.getExp_id(), expense );
            }
            return expenseList;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Expense updateClaimInformation(Expense expense) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update expense set amount = ?, description = ?, category = ?, status = ? where exp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, expense.getAmount());
            ps.setString(2, expense.getDescription());
            ps.setString(3, expense.getCategory().toString());
            ps.setString(4, expense.getStatus().toString());
            ps.setInt(5, expense.getExp_id());

            ps.executeUpdate();

            return expense;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Expense updateClaimsStatus(Expense expense, Status status) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "update expense set status = ? where exp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, expense.getStatus().toString());
            ps.setInt(2, expense.getExp_id());

            ps.executeUpdate();
            return expense;

        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
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
