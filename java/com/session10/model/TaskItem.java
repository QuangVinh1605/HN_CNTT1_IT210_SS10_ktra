package com.session10.model;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskItem {
    private String id;
    @NotBlank(message = "Title ko đc để trống")
    @Size(min = 5, message = "Title phải có độ dài từ 5 ký tự")
    private String title;
    @NotNull(message = "Deadline ko để trống")
    @Future(message = "Deadline nhập ngày trong tiếp theo")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    @NotBlank(message = "Priority chọn")
    @Pattern(regexp = "HIGH|MEDIUM|LOW",
            message = "Priority phải là HIGH, MEDIUM, LOW")
    private String priority;
    public TaskItem(){}

    public TaskItem(String id, String title, LocalDate deadline, String priority) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

