package ru.timofeev.project_developing.service.impl;

import org.springframework.stereotype.Service;
import ru.timofeev.project_developing.model.Project;
import ru.timofeev.project_developing.repository.ProjectRepository;
import ru.timofeev.project_developing.service.IProjectService;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements IProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository repository) {
        this.projectRepository = repository;
    }

    @Override
    public void saveOrUpdateProject(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project getProjectById(Long id) {
        Optional<Project> foundProject = projectRepository.findById(id);
        if (foundProject.isEmpty()) {
            throw new IllegalArgumentException("Нет такого проекта");
        }
        return foundProject.get();
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }
}
