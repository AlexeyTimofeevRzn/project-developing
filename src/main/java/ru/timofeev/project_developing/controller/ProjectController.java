package ru.timofeev.project_developing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.timofeev.project_developing.dao.IProjectDao;
import ru.timofeev.project_developing.model.Project;
import ru.timofeev.project_developing.repository.ProjectRepository;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private ProjectRepository projectService;
    private IProjectDao projectDao;

    public ProjectController(ProjectRepository projectService, IProjectDao projectDao) {
        this.projectService = projectService;
        this.projectDao = projectDao;
    }

    @GetMapping("/list")
    public String getProjects(Model model) {
        model.addAttribute("projects", projectService.findAll());
        // проекты и пользаки
        return "projects/allProjects";
    }

    @GetMapping("/{id}")
    public String showProjectDetails(@PathVariable Long id, Model model) {
        Project project = projectService.findById(id).get(); // Получение проекта по ID
//        List<EmployeeProjectRole> projectRoleList = projectRoleService.getProjectRolesByProjectId(id);
        model.addAttribute("project", project); // Передача проекта в шаблон
        model.addAttribute("projectTotalPayload", projectDao.calculateProjectPayload(project.getCode()));
        return "projects/projectPage";
    }
}
