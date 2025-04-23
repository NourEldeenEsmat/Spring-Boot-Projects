package com.taskManagementSystem.taskManagementSystem.Controler;

import com.taskManagementSystem.taskManagementSystem.Dto.CommentDto;
import com.taskManagementSystem.taskManagementSystem.Dto.TaskDto;
import com.taskManagementSystem.taskManagementSystem.Entity.TasksComments;
import com.taskManagementSystem.taskManagementSystem.Enums.Status;
import com.taskManagementSystem.taskManagementSystem.Services.EmployeeServices.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Controller
public class EmployeeCtrl {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/get_employee_tasks/{userId}")
    public ResponseEntity<?> getEmpComments(@PathVariable Long userId) {
        try {
            List<TaskDto> tasks = employeeServices.getEmployeeTasks(userId);
            return ResponseEntity.ok(tasks);
        } catch (Error e) {
            return new ResponseEntity("something went wrong..." + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/change_status/{taskId}/{newStatus}")
    public ResponseEntity<?> changeStatus(@PathVariable Long taskId, @PathVariable Status newStatus) {
        try {
            Status status = employeeServices.changeStatus(taskId, newStatus);
            return ResponseEntity.ok(status);
        } catch (Error e) {
            return new ResponseEntity("something went wrong..." + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_task_details/{id}")
    public ResponseEntity<?> getTask(@PathVariable Long id) {
        try {
            TaskDto taskDto = employeeServices.viewTask(id);
            return ResponseEntity.ok(taskDto);
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }
}
