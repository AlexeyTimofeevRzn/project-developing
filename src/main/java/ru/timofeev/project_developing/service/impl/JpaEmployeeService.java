package ru.timofeev.project_developing.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.timofeev.project_developing.model.Employee;
import ru.timofeev.project_developing.repository.EmployeeRepository;
import ru.timofeev.project_developing.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jpaEmployeeService")
@Primary
public class JpaEmployeeService implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    public JpaEmployeeService(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> foundEmployee = employeeRepository.findById(id);
        if (foundEmployee.isEmpty()) {
            throw new IllegalArgumentException("Пользователя с таким id не существует");
        }
        return foundEmployee.get();
    }

    @Override
    public Employee getEmployeeByLogin(String login) {
        Optional<Employee> foundEmployee = employeeRepository.findByLogin(login);
        if (foundEmployee.isEmpty()) {
            throw new IllegalArgumentException("Пользователя с таким login не существует");
        }
        return foundEmployee.get();
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeesUsingDynamicQuery(String query) {
        return null;
    }
}
