package com.crisscrosscrass.EmployeeCMS.factory;

import com.crisscrosscrass.EmployeeCMS.models.Employee;
import com.crisscrosscrass.EmployeeCMS.models.EmployeeDao;
import com.mysql.cj.jdbc.DatabaseMetaData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDao implements EmployeeDao {
    private final Connection connection;

    public JdbcEmployeeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (firstName, lastName, eMail, salary) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            createTableIfNotExists(connection, "employees");
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.geteMail());
            statement.setDouble(4, employee.getSalary());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    public boolean isTableExists(Connection connection, String tableName) throws SQLException {
        java.sql.DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, tableName, null);
        return resultSet.next();
    }

    public void createTableIfNotExists(Connection connection, String tableName) throws SQLException {
        if (!isTableExists(connection, tableName)) {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE " + tableName + " (" +
                    "employeeId INT PRIMARY KEY AUTO_INCREMENT, " +
                    "firstName VARCHAR(20) NOT NULL, " +
                    "lastName VARCHAR(20), " +
                    "eMail VARCHAR(200), " +
                    "salary DOUBLE NOT NULL" +
                    ")";
            statement.executeUpdate(sql);
            statement.close();
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        String sql = "SELECT * FROM employees WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return createEmployeeFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = createEmployeeFromResultSet(resultSet);
                employees.add(employee);
            }
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, salary = ? WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.geteMail());
            statement.setDouble(4, employee.getSalary());
            statement.setInt(5, employee.getEmployeeId());
            statement.executeUpdate();
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeId);
            statement.executeUpdate();
        } catch (SQLException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    private Employee createEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getInt("employee_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.seteMail(resultSet.getString("email"));
        employee.setSalary(resultSet.getDouble("salary"));
        return employee;
    }
}
