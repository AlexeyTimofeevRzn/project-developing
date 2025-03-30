package ru.timofeev.project_developing.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ru.timofeev.project_developing.model.EmployeeProjectRole;
import ru.timofeev.project_developing.repository.EmployeeProjectRoleRepository;
import ru.timofeev.project_developing.service.IEmployeeProjectRoleService;

import java.util.List;

@Service
public class EmployeeProjectRoleService implements IEmployeeProjectRoleService {

    private EmployeeProjectRoleRepository repository;

    public EmployeeProjectRoleService(EmployeeProjectRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    @Modifying
    public void save(EmployeeProjectRole projectRole) {
        repository.save(projectRole);
    }

    @Override
    public List<EmployeeProjectRole> getProjectRolesByEmployeeId(Long employeeId) {
        return repository.getEmployeeProjectRoleByEmployee_Id(employeeId);
    }

    @Override
    public List<EmployeeProjectRole> getProjectRolesByProjectId(Long projectId) {
        return repository.getEmployeeProjectRoleByProject_Id(projectId);
    }
}
