package com.example.taskmanager.dto;

import lombok.Data;
import java.util.Date;

@Data
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Date dueDate;
    private String priority;
    private String status;
    private Long userId;
}
