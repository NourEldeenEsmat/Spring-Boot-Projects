package com.taskManagementSystem.taskManagementSystem.Services.EmployeeServices;

import com.taskManagementSystem.taskManagementSystem.Dto.CommentDto;
import com.taskManagementSystem.taskManagementSystem.Dto.TaskDto;
import com.taskManagementSystem.taskManagementSystem.Entity.Task;
import com.taskManagementSystem.taskManagementSystem.Entity.TasksComments;
import com.taskManagementSystem.taskManagementSystem.Entity.User;
import com.taskManagementSystem.taskManagementSystem.Enums.Status;
import com.taskManagementSystem.taskManagementSystem.Repositry.AuthRepo;
import com.taskManagementSystem.taskManagementSystem.Repositry.CommentRepo;
import com.taskManagementSystem.taskManagementSystem.Repositry.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeServices {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private AuthRepo authRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Override
    public List<TaskDto> getEmployeeTasks(Long userId) {
        Optional<User> user = authRepo.findById(userId);
        List<Task> tasks = taskRepo.findAllByEmployee(user.get().getUserName());
        return tasks.stream().map(Task::taskToDto).toList();
    }

    @Override
    public Status changeStatus(TaskDto taskDto, Status newStatus) {
        taskDto.setStatus(newStatus);
        Task task = taskRepo.save(taskDto.toTask());
        return task.taskToDto().getStatus();
    }

    @Override
    public TaskDto viewTask(Long taskId) {
        Optional<Task> task = taskRepo.findById(taskId);
        return task.get().taskToDto();
    }

    @Override
    public List<CommentDto> getComments(Long taskId) {
        Optional<Task> task = taskRepo.findById(taskId);
       List<TasksComments> comments = commentRepo.findAllByTask(task.get());
        return comments.stream().map(TasksComments::toDto).toList();
    }


}
