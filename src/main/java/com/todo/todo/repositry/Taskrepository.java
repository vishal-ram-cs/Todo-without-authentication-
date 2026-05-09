package com.todo.todo.repositry;

import com.todo.todo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Taskrepository extends JpaRepository<Task,Long> {

}
