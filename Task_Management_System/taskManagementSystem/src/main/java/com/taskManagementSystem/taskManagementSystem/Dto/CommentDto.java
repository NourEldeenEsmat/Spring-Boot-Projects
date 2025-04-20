package com.taskManagementSystem.taskManagementSystem.Dto;

import com.taskManagementSystem.taskManagementSystem.Entity.TasksComments;
import lombok.Data;

@Data
public class CommentDto {
    private Long commentId;
    private String comment;
    private Long taskId;
    private Long commenterId;
    public TasksComments dtoToComment(){
        TasksComments tasksComments =new  TasksComments();
        tasksComments.setComment(comment);
        tasksComments.setId(commentId);
        return tasksComments;
    }
}
