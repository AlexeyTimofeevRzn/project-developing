package ru.timofeev.project_developing.service;

import ru.timofeev.project_developing.model.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee getEmployeeById(Long id);

    Employee getEmployeeByLogin(String login);

    List<Employee> getEmployees();

    List<Employee> getEmployeesUsingDynamicQuery(String query);

    void saveOrUpdateEmployee(Employee employee);
}
