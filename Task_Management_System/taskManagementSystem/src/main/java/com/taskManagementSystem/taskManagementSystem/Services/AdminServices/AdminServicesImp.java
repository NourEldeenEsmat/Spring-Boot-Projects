package com.taskManagementSystem.taskManagementSystem.Services.AdminServices;

import com.taskManagementSystem.taskManagementSystem.Dto.CommentDto;
import com.taskManagementSystem.taskManagementSystem.Dto.TaskDto;
import com.taskManagementSystem.taskManagementSystem.Entity.Task;
import com.taskManagementSystem.taskManagementSystem.Entity.TasksComments;
import com.taskManagementSystem.taskManagementSystem.Entity.User;
import com.taskManagementSystem.taskManagementSystem.Repositry.AuthRepo;
import com.taskManagementSystem.taskManagementSystem.Repositry.CommentRepo;
import com.taskManagementSystem.taskManagementSystem.Repositry.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServicesImp implements AdminServices {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private AuthRepo authRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Override
    public TaskDto saveTask(TaskDto taskDto) {
            User employee = authRepo.findByUserName(taskDto.getEmployee());
            if (employee != null) {
                Optional<User> user = authRepo.findById(taskDto.getAdminId());
                Task task = taskDto.toTask();
                task.setUser(user.get());
                Task task1 = taskRepo.save(task);
                return task1.taskToDto();
            }
       return null;
    }

    @Override
    public List<TaskDto> getAllTasks(Long id) {
        Optional<User> user = authRepo.findById(id);
        List<Task> tasks = taskRepo.findAllByUser(user.get());
        return tasks.stream().map(Task::taskToDto).toList();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public TaskDto editTask(TaskDto taskDto) {
        Optional<User> user = authRepo.findById(taskDto.getAdminId());
        Task task = taskDto.toTask();
        task.setUser(user.get());
        Task task1 = taskRepo.save(task);
        return task1.taskToDto();
    }

    @Override
    public TaskDto viewTask(Long id) {
        Optional<Task> task=taskRepo.findById(id);
        TaskDto taskDto = task.get().taskToDto();
        return taskDto;
    }

    @Override
    public CommentDto addComment(CommentDto dto) {
        Optional<Task> tasksComments = taskRepo.findById(dto.getTaskId());
        Optional<User> user = authRepo.findById(dto.getCommenterId());
        TasksComments comments = dto.dtoToComment();
        comments.setTask(tasksComments.get());
        comments.setUser(user.get());
        TasksComments tasksComments1 = commentRepo.save(comments);
        return tasksComments1.toDto();
    }

    @Override
    public List<CommentDto> getAllTaskComments(Long taskId) {
        Optional<Task> task=taskRepo.findById(taskId);
        List<TasksComments> commentDtoList = commentRepo.findAllByTask(task.get());
        return commentDtoList.stream().map(TasksComments::toDto).toList();
    }
}
