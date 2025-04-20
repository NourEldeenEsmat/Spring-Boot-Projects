package com.taskManagementSystem.taskManagementSystem.Entity;

import com.taskManagementSystem.taskManagementSystem.Dto.CommentDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "comments")
@Data
public class TasksComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "taskId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Task task;
    @ManyToOne
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    public CommentDto toDto(){
        CommentDto dto = new CommentDto();
        dto.setCommentId(id);
        dto.setComment(comment);
        dto.setTaskId(task.getTaskId());
        dto.setCommenterId(user.getUserId());
        return dto;
    }
}
