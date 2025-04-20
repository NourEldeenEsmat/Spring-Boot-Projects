package com.taskManagementSystem.taskManagementSystem.Controler;

import com.taskManagementSystem.taskManagementSystem.Dto.TaskDto;
import com.taskManagementSystem.taskManagementSystem.Services.EmployeeServices.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EmployeeCtrl {
    @Autowired
    private EmployeeServices employeeServices;
    @GetMapping("/get_employee_tasks/{userId}")
    public ResponseEntity<?> getEmpComments(@PathVariable Long userId){
        try {
          List<TaskDto> tasks = employeeServices.getEmployeeTasks(userId);
          return ResponseEntity.ok(tasks);
        }catch (Error e){
            return new ResponseEntity("something went wrong..."+e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
