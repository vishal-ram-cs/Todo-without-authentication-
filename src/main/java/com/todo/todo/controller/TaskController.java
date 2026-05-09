package com.todo.todo.controller;

import org.springframework.ui.Model;
import com.todo.todo.Services.TaskService;
import com.todo.todo.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String getTasks(Model model){
        List<Task> Tasks =taskService. getAllTasks();
        model.addAttribute("Tasks",Tasks);
        return "Tasks" ;

    }
    @PostMapping("/")

    public String createTask(@RequestParam String title){
       taskService. createTask(title);

        return "redirect:/" ;

    }
    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable Long id){
       taskService.deleteTask(id);
        return "redirect:/" ;
    }
    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/" ;
    }


}
