package com.taskManagementSystem.taskManagementSystem.Entity;

import com.taskManagementSystem.taskManagementSystem.Dto.TaskDto;
import com.taskManagementSystem.taskManagementSystem.Enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.web.service.annotation.DeleteExchange;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String title;
    private String description;
    private String date;
    private String priority;
    private String employee;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public TaskDto taskToDto() {
        TaskDto dto = new TaskDto();
        dto.setDate(date);
        dto.setEmployee(employee);
        dto.setDescription(description);
        dto.setPriority(priority);
        dto.setTitle(title);
        dto.setId(taskId);
        dto.setStatus(status);
        dto.setAdminId(user.getUserId());
        return dto;
    }
}
