package com.todoapp.model;

import java.util.Date;

public class Task {

    private int taskId;
    private String taskName;
    private Date taskCreationDate;
    private int userId;

    public Task() {
        super();
    }

    public Task(int taskId, String taskName, Date taskCreationDate, int userId) {
        super();
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskCreationDate = taskCreationDate;
        this.userId = userId;
    }

    public Task(String taskName, Date taskCreationDate) {
        this.taskName = taskName;
        this.taskCreationDate = taskCreationDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskCreationDate() {
        return taskCreationDate;
    }

    public void setTaskCreationDate(Date taskCreationDate) {
        this.taskCreationDate = taskCreationDate;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskCreationDate=" + taskCreationDate
                + ", userId=" + userId + "]";
    }
}
