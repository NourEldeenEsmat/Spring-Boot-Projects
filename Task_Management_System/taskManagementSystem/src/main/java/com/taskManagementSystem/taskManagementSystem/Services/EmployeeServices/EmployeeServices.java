package com.taskManagementSystem.taskManagementSystem.Services.EmployeeServices;

import com.taskManagementSystem.taskManagementSystem.Dto.CommentDto;
import com.taskManagementSystem.taskManagementSystem.Dto.TaskDto;
import com.taskManagementSystem.taskManagementSystem.Entity.Task;
import com.taskManagementSystem.taskManagementSystem.Enums.Role;
import com.taskManagementSystem.taskManagementSystem.Enums.Status;

import java.util.List;

public interface EmployeeServices {
    List<TaskDto> getEmployeeTasks(Long userId);
    Status changeStatus (TaskDto taskDto,Status newStatus);
    TaskDto viewTask(Long taskId);
    List<CommentDto> getComments(Long taskId);
}
