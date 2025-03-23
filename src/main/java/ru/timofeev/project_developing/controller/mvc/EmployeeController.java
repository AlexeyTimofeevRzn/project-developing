package ru.timofeev.project_developing.controller.mvc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.timofeev.project_developing.service.IEmployeeService;

@Controller
@RequestMapping("/users")
public class EmployeeController {

    private IEmployeeService employeeService;

    public EmployeeController(@Qualifier("jpaEmployeeService") IEmployeeService service) {
        this.employeeService = service;
    }

    @GetMapping("/list")
    public String getUsers(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "employees/list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employees/profile";
    }

    @GetMapping("/byLogin/{login}")
    public String getUserByLogin(@PathVariable("login") String login, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeByLogin(login));
        return "employees/profile";
    }
}
