package ru.timofeev.project_developing.service;

import ru.timofeev.project_developing.model.Project;

import java.util.List;

public interface IProjectService {

    void saveOrUpdateProject(Project project);

    Project getProjectById(Long id);

    List<Project> getProjects();
}
