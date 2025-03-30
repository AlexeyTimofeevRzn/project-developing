package ru.timofeev.project_developing.controller.mvc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.timofeev.project_developing.enums.ProjectRole;
import ru.timofeev.project_developing.model.Employee;
import ru.timofeev.project_developing.model.EmployeeProjectRole;
import ru.timofeev.project_developing.service.IEmployeeProjectRoleService;
import ru.timofeev.project_developing.service.IEmployeeService;
import ru.timofeev.project_developing.service.IProjectService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class EmployeeController {

    private IEmployeeService employeeService;
    private IProjectService projectService;
    private IEmployeeProjectRoleService projectRoleService;

    public EmployeeController(
            @Qualifier("jpaEmployeeService") IEmployeeService employeeService,
            IProjectService projectService,
            IEmployeeProjectRoleService employeeProjectRoleService
    ) {
        this.employeeService = employeeService;
        this.projectService = projectService;
        this.projectRoleService = employeeProjectRoleService;
    }

    @GetMapping("/list")
    public String getUsers(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees/list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        List<EmployeeProjectRole> assignments = projectRoleService.getProjectRolesByEmployeeId(id);
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("assignments", assignments);
        return "employees/profile";
    }

    @GetMapping("/byLogin/{login}")
    public String getUserByLogin(@PathVariable("login") String login, Model model) {
        Employee employee = employeeService.getEmployeeByLogin(login);
        List<EmployeeProjectRole> assignments = projectRoleService.getProjectRolesByEmployeeId(employee.getId());
        model.addAttribute("employee", employee);
        model.addAttribute("assignments", assignments);
        return "employees/profile";
    }

    @GetMapping("/new")
    public String showCreateEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/create-employee"; // Имя шаблона
    }

    @PostMapping("/create")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.saveOrUpdateEmployee(employee);
        return "redirect:/users/list";
    }

    @GetMapping("/{id}/set-on-project")
    public String getSettingOnProjectPage(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("projects", projectService.getProjects());
        model.addAttribute("roles", ProjectRole.values()); // Передаем роли
        model.addAttribute("assignment", new EmployeeProjectRole());
        return "employees/set-on-project";
    }

    @PostMapping("/{id}/set-on-project")
    public String assignEmployeeToProject(
            @PathVariable Long id,
            @ModelAttribute EmployeeProjectRole assignment
    ) {
        Employee employee = employeeService.getEmployeeById(id);
        assignment.setEmployee(employee); // Устанавливаем сотрудника в назначение
        projectRoleService.save(assignment);
        return "redirect:/users/" + id; // Перенаправление на список сотрудников
    }
}
