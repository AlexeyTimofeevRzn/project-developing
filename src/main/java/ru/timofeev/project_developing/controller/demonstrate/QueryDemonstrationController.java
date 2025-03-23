package ru.timofeev.project_developing.controller.demonstrate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.timofeev.project_developing.service.IEmployeeService;

@Controller
@RequestMapping("/demonstration")
public class QueryDemonstrationController {

    private final IEmployeeService employeeService;

    public QueryDemonstrationController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/static-query")
    public String showEmployeesByStaticQuery(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "static-query";
    }

    @GetMapping("/dynamic-query")
    public String showEmployeesByDynamicQuery() {
        return "dynamic-query";
    }

    @PostMapping("/dynamic-query")
    public String getEmployeesByDynamicQuery(@RequestParam String sql, Model model) {
        model.addAttribute("foundedEmployees", employeeService.getEmployeesUsingDynamicQuery(sql));
        return "dynamic-query";
    }

    @GetMapping("/parametrized-query")
    public String showEmployeesByParametrizedQuery() {
        return "parametrized-query";
    }

    @PostMapping("/parametrized-query")
    public String getEmployeesByParametrizedQuery(@RequestParam String login, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeByLogin(login));
        return "parametrized-query";
    }
}
