package ru.timofeev.project_developing.service.impl;

import org.springframework.stereotype.Service;
import ru.timofeev.project_developing.dao.IEmployeeDao;
import ru.timofeev.project_developing.model.Employee;
import ru.timofeev.project_developing.service.IEmployeeService;

import java.util.List;

@Service
public class PostgresEmployeeService implements IEmployeeService {

    private final IEmployeeDao employeeDao;

    public PostgresEmployeeService(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public Employee getEmployeeByLogin(String login) {
        return employeeDao.getEmployeeByLogin(login);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public List<Employee> getEmployeesUsingDynamicQuery(String query) {
        return employeeDao.getEmployeesByQuery(query);
    }
}
