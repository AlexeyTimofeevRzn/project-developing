package ru.timofeev.project_developing.util.mapper;

import ru.timofeev.project_developing.model.Employee;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper {

    private static final String ID_ATTRIBUTE = "id";
    private static final String LOGIN_ATTRIBUTE = "login";
    private static final String NAME_ATTRIBUTE = "name";
    private static final String SURNAME_ATTRIBUTE = "surname";
    private static final String PASSWORD_ATTRIBUTE = "password";
    private static final String BIRTHDATE_ATTRIBUTE = "birthdate";

    private EmployeeMapper() {

    }

    public static Employee map(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong(ID_ATTRIBUTE));
        employee.setLogin(resultSet.getString(LOGIN_ATTRIBUTE));
        employee.setSurname(resultSet.getString(SURNAME_ATTRIBUTE));
        employee.setName(resultSet.getString(NAME_ATTRIBUTE));
        employee.setPassword(resultSet.getString(PASSWORD_ATTRIBUTE));
        employee.setBirhdate(Date.valueOf(resultSet.getString(BIRTHDATE_ATTRIBUTE)));
        return employee;
    }
}
