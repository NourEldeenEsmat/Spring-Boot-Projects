package com.taskManagementSystem.taskManagementSystem.Dto;

import com.taskManagementSystem.taskManagementSystem.Entity.Task;
import com.taskManagementSystem.taskManagementSystem.Enums.Status;
import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private String date;
    private String priority;
    private String employee;
    private Status status;
    private Long adminId;

    public Task toTask() {
        Task task = new Task();
        task.setTaskId(id);
        task.setDate(date);
        task.setDescription(description);
        task.setTitle(title);
        task.setPriority(priority);
        task.setEmployee(employee);
        task.setStatus(status);
        return task;
    }
}
// {
//         "title":"one piece",
//         "description":"kilo kony",
//         "date":"20/10/2000",
//         "priority":"whatever",
//         "employee":"nour kamel",
//         "adminId":"1"
// }