package com.taskManagementSystem.taskManagementSystem.Controler;

import com.taskManagementSystem.taskManagementSystem.Dto.CommentDto;
import com.taskManagementSystem.taskManagementSystem.Dto.TaskDto;
import com.taskManagementSystem.taskManagementSystem.Entity.Task;
import com.taskManagementSystem.taskManagementSystem.Services.AdminServices.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("edge://")
@Controller
public class AdminCtrl {
    @Autowired
    AdminServices adminServices;

    @PostMapping("/add_task")
    public ResponseEntity<?> addTask(@RequestBody TaskDto taskDto) {
        try {
            TaskDto dto = adminServices.saveTask(taskDto);
            return ResponseEntity.ok(dto);
        } catch (Error e) {
            return new ResponseEntity("Task NotPosted", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_admin_tasks/{id}")
    public ResponseEntity<?> getAllTasks(@PathVariable Long id) {
        try {
            List<TaskDto> tasks = adminServices.getAllTasks(id);
            return ResponseEntity.ok(tasks);
        } catch (Error e) {
            return new ResponseEntity<>("something went wrong" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete_task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        try {
            adminServices.deleteTask(id);
            return ResponseEntity.ok("deleted");
        } catch (Error e) {
            return new ResponseEntity("something went wrong...", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit_task")
    public ResponseEntity<?> editTask(@RequestBody TaskDto taskDto) {
        try {
            TaskDto task = adminServices.editTask(taskDto);
            return ResponseEntity.ok(task);
        } catch (Error e) {
            return new ResponseEntity("something went wrong!!!" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/view_task/{id}")
    public ResponseEntity<?> viewTask(@PathVariable Long id) {
        try {
            TaskDto dto = adminServices.viewTask(id);
            return ResponseEntity.ok(dto);
        } catch (Error e) {
            return new ResponseEntity("something went wrong!!!" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add_comment")
    public ResponseEntity<?> addComment(@RequestBody CommentDto commentDto) {
        try {
            CommentDto dto = adminServices.addComment(commentDto);
            return ResponseEntity.ok(dto);
        } catch (Error e) {
            return new ResponseEntity("something went wrong!!!" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_task_comments/{taskId}")
    public ResponseEntity<?> getTaskComments(@PathVariable Long taskId) {
        try {
            List<CommentDto> dtoList = adminServices.getAllTaskComments(taskId);
            return ResponseEntity.ok(dtoList);
        } catch (Error e) {
            return new ResponseEntity("something went wrong!!!" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
