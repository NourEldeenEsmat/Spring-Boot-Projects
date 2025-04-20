package com.taskManagementSystem.taskManagementSystem.Repositry;

import com.taskManagementSystem.taskManagementSystem.Entity.Task;
import com.taskManagementSystem.taskManagementSystem.Entity.TasksComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<TasksComments,Long> {
    List<TasksComments> findAllByTask(Task task);
}
