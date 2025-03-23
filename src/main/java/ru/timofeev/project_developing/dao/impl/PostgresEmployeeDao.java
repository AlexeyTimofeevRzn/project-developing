package ru.timofeev.project_developing.dao.impl;

import org.springframework.stereotype.Service;
import ru.timofeev.project_developing.dao.IEmployeeDao;
import ru.timofeev.project_developing.model.Employee;
import ru.timofeev.project_developing.util.mapper.EmployeeMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PostgresEmployeeDao implements IEmployeeDao {

    private final DataSource dataSource;
    private final String SELECT_QUERY = "SELECT * FROM employee";

    public PostgresEmployeeDao(DataSource hikariDataSource) {
        this.dataSource = hikariDataSource;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee where id = ?")
        ) {
            statement.setLong(1, id);
            var resultSet = statement.executeQuery();
            resultSet.next();
            return EmployeeMapper.map(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return new Employee();
        }
    }

    @Override
    public Employee getEmployeeByLogin(String login) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee where login = ?")
        ) {
            statement.setString(1, login);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return EmployeeMapper.map(resultSet);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new Employee();
        }
    }

    @Override
    public List<Employee> getEmployeesByQuery(String query) {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()
        ) {
            var resultSet = statement.executeQuery(query);
            var result = new ArrayList<Employee>();
            resultSet.next();
            while (resultSet.next()) {
                Employee employee = EmployeeMapper.map(resultSet);
                result.add(employee);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public List<Employee> getEmployees() {
        return this.getEmployeesByQuery(SELECT_QUERY);
    }
}
