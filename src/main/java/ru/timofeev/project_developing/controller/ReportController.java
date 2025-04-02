package ru.timofeev.project_developing.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.timofeev.project_developing.config.Birt;

@Controller
@RequestMapping("/report")
public class ReportController {

    private Birt birt;

    public ReportController(Birt birt) {
        this.birt = birt;
    }

    @GetMapping("/page")
    public String getReportPage() {
        return "report/reportPage";
    }

    @PostMapping("/generate")
    public String generateReport(@ModelAttribute("id") String id, HttpServletResponse response, HttpServletRequest request) {
        birt.generatePDF(id, response, request);

        return "redirect:/report";
    }
}
