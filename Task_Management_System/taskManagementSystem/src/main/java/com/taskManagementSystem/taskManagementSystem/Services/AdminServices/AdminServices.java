package com.taskManagementSystem.taskManagementSystem.Services.AdminServices;

import com.taskManagementSystem.taskManagementSystem.Dto.CommentDto;
import com.taskManagementSystem.taskManagementSystem.Dto.TaskDto;

import java.util.List;

public interface AdminServices {
    public TaskDto saveTask(TaskDto taskDto);
    public List<TaskDto> getAllTasks(Long id);
    public void deleteTask(Long id);
    public TaskDto editTask(TaskDto taskDto);
    public TaskDto viewTask(Long id);
    public CommentDto addComment(CommentDto dto);
    public List<CommentDto> getAllTaskComments(Long taskId);
}
