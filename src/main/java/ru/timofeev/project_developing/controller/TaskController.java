package ru.timofeev.project_developing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.timofeev.project_developing.dao.ITaskDao;
import ru.timofeev.project_developing.repository.TaskRepository;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;
    private final ITaskDao taskDao;

    public TaskController(TaskRepository taskRepository, ITaskDao taskDao) {
        this.taskRepository = taskRepository;
        this.taskDao = taskDao;
    }

    @GetMapping("/tasks")
    public String showTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks/allTasks";
    }

    @PostMapping("/tasks/increase-payload")
    public String increasePayload(Model model) {
        taskDao.increaseTaskPayload();
        model.addAttribute("success", true);
        return "redirect:/tasks";
    }
}
