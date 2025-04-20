package com.taskManagementSystem.taskManagementSystem.Repositry;

import com.taskManagementSystem.taskManagementSystem.Entity.Task;
import com.taskManagementSystem.taskManagementSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
    List<Task> findAllByUser(User admin);
    List<Task> findAllByEmployee(String employee);
}
