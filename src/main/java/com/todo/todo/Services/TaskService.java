package com.todo.todo.Services;


import com.todo.todo.models.Task;
import com.todo.todo.repositry.Taskrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final Taskrepository taskRespository;

    public TaskService(Taskrepository taskRespository) {
        this.taskRespository = taskRespository;
    }

    public List<Task> getAllTasks() {
        return taskRespository.findAll();
    }

    public void createTask(String title) {
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRespository.save(task);

    }

    public void deleteTask(Long id) {
        taskRespository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task =taskRespository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("invalid task id"));
                task.setCompleted(!task.isCompleted());
                taskRespository.save(task);


    }
}

