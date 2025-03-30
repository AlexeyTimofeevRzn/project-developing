package ru.timofeev.project_developing.service;

import ru.timofeev.project_developing.model.EmployeeProjectRole;

import java.util.List;

public interface IEmployeeProjectRoleService {

    void save(EmployeeProjectRole projectRole);

    List<EmployeeProjectRole> getProjectRolesByEmployeeId(Long employeeId);

    List<EmployeeProjectRole> getProjectRolesByProjectId(Long projectId);
}
