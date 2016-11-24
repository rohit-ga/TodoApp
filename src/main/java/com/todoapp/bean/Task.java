package com.todoapp.bean;

import java.util.Date;

public class Task {

    private int taskId;
    private String taskName;
    private Date taskCreationDate;

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
        return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskCreationDate=" + taskCreationDate + "]";
    }

}
