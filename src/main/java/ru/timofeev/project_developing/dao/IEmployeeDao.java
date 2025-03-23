package ru.timofeev.project_developing.dao;

import ru.timofeev.project_developing.model.Employee;

import java.util.List;

public interface IEmployeeDao {

    Employee getEmployeeById(Long id);
    Employee getEmployeeByLogin(String login);
    List<Employee> getEmployeesByQuery(String query);
    List<Employee> getEmployees();
}
