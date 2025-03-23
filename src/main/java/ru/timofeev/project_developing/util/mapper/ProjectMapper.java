package ru.timofeev.project_developing.util.mapper;

import ru.timofeev.project_developing.enums.ProjectStatus;
import ru.timofeev.project_developing.enums.ProjectType;
import ru.timofeev.project_developing.model.Project;
import ru.timofeev.project_developing.model.dto.ProjectDTO;

import java.sql.Date;

public class ProjectMapper {

    private ProjectMapper() {

    };

    public static Project mapToProject(ProjectDTO projectDTO) {
        Project mappedProject = new Project();
        mappedProject.setCode(projectDTO.getCode());
        mappedProject.setName(projectDTO.getName());
        mappedProject.setDescription(projectDTO.getDescription());
        mappedProject.setDateOfStart(Date.valueOf(projectDTO.getDateOfStart()));
        mappedProject.setFactDateOfEnd(null);
        mappedProject.setPlannedDateOfEnd(Date.valueOf(projectDTO.getPlannedDateOfEnd()));
        mappedProject.setType(ProjectType.valueOf(projectDTO.getType()));
        mappedProject.setPlannedPayload(projectDTO.getPlannedPayload());
        mappedProject.setResponsibleLogin(projectDTO.getResponsibleLogin());
        mappedProject.setStatus(ProjectStatus.valueOf(projectDTO.getStatus()));
        return mappedProject;
    }
}
