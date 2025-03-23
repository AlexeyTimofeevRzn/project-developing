package ru.timofeev.project_developing.controller.demonstrate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.timofeev.project_developing.service.IConnectionInfoService;

@Controller
@RequestMapping("/connection-info")
public class DatabaseInfoController {

    private final IConnectionInfoService connectionInfoService;

    public DatabaseInfoController(IConnectionInfoService infoService) {
        this.connectionInfoService = infoService;
    }

    @GetMapping("/lab1")
    public String lab1(Model model) {
        model.addAttribute("info", connectionInfoService.getConnectionInfo());
        return "connection";
    }
}
