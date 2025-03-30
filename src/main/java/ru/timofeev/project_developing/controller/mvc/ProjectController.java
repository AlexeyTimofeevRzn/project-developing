package ru.timofeev.project_developing.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.timofeev.project_developing.enums.ProjectStatus;
import ru.timofeev.project_developing.enums.ProjectType;
import ru.timofeev.project_developing.model.EmployeeProjectRole;
import ru.timofeev.project_developing.model.Project;
import ru.timofeev.project_developing.service.IEmployeeProjectRoleService;
import ru.timofeev.project_developing.service.IProjectService;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private IProjectService projectService;
    private IEmployeeProjectRoleService projectRoleService;

    public ProjectController(IProjectService projectService, IEmployeeProjectRoleService roleService) {
        this.projectService = projectService;
        this.projectRoleService = roleService;
    }

    @GetMapping("/new")
    public String createProjectPage(Model model) {
        // TODO: добавить пользаков на модель (nice future)
        model.addAttribute("project", new Project());
        model.addAttribute("projectTypes", ProjectType.values()); // Передача всех значений enum
        model.addAttribute("projectStatuses", ProjectStatus.values());
        return "projects/createProject";
    }

    @PostMapping("/create")
    public String createNewProject(@ModelAttribute Project projectDTO, Model model) {
        // тут проверять, что такой челик есть в бд
        projectService.saveOrUpdateProject(projectDTO);
        return "main";
    }

    @GetMapping("/list")
    public String getProjects(Model model) {
        model.addAttribute("projects", projectService.getProjects());
        // проекты и пользаки
        return "projects/allProjects";
    }

    @GetMapping("/{id}")
    public String showProjectDetails(@PathVariable Long id, Model model) {
        Project project = projectService.getProjectById(id); // Получение проекта по ID
        List<EmployeeProjectRole> projectRoleList = projectRoleService.getProjectRolesByProjectId(id);
        model.addAttribute("project", project); // Передача проекта в шаблон
        model.addAttribute("assignments", projectRoleList);
        return "projects/projectPage";
    }
}
