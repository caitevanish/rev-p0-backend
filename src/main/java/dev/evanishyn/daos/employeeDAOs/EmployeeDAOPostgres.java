package dev.evanishyn.daos.employeeDAOs;

import dev.evanishyn.entities.Employee;
import dev.evanishyn.utilities.ConnectionUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDAOPostgres implements EmployeeDAO{


    @Override
    public Employee createEmployee(Employee employee) {
        try (Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into employee values (default, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getfName());
            preparedStatement.setString(2, employee.getlName());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();

            int generateKey = rs.getInt("emp_id");
            employee.setEmp_id(generateKey);
            return employee;

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(int id) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from employee where employee.emp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Employee employee = new Employee();
            employee.setEmp_id(rs.getInt("emp_id"));
            employee.setfName(rs.getString("fname"));
            employee.setlName(rs.getString("lname"));

            return employee;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<Integer, Employee> getEmployeeList() {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "select * from employee";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Map<Integer, Employee> employeeList = new HashMap<>();

            while(rs.next()){
                Employee employee = new Employee();
                employee.setEmp_id(rs.getInt("emp_id"));
                employee.setfName(rs.getString("fname"));
                employee.setlName(rs.getString("lname"));
                employeeList.put(employee.getEmp_id(), employee);
            }
            return employeeList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee updateEmployeeInfo(Employee employee) {
        try(Connection conn = ConnectionUtil.createConnection()) {
            String sql = "update employee set fname = ?, lname = ? where emp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, employee.getfName());
            ps.setString(2, employee.getlName());
            ps.setInt(3, employee.getEmp_id());

            ps.executeUpdate();
            return employee;

        } catch(SQLException e){
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public boolean deleteEmployeeAccount(int id) {
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "delete from employee where emp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            return true;
        }
            catch(SQLException e){
            e.printStackTrace();
            return false;
            }
    }
}
