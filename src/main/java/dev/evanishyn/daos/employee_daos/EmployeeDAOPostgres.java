package dev.evanishyn.daos.employee_daos;

import dev.evanishyn.entities.Employee;
import dev.evanishyn.utilities.ConnectionUtil;

import java.sql.*;
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

            int generateKey = rs.getInt("id");
            employee.setId(generateKey);

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return null;
    }

    @Override
    public Map<Integer, Employee> getEmployeeList() {
        return null;
    }

    @Override
    public Employee updateEmployeeInfo(Employee employee) {
        return null;
    }

    @Override
    public boolean deleteEmployeeAccount(int id) {
        return false;
    }
}
