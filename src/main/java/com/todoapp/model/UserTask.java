package com.todoapp.model;

public class UserTask {

    private int userId;
    private int taskId;
    private String startTime;
    private String endTime;
    private String description;
    private int userTaskId;

    public UserTask() {
        super();
    }

    public UserTask(int userId, int taskId, String startTime, String endTime, String description, int userTaskId) {
        super();
        this.userId = userId;
        this.taskId = taskId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.userTaskId = userTaskId;
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

    public int getUserTaskId() {
        return userTaskId;
    }

    public void setUserTaskId(int userTaskId) {
        this.userTaskId = userTaskId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserTask [userId=" + userId + ", taskId=" + taskId + ", startTime=" + startTime + ", endTime="
                + endTime + ", description=" + description + ", userTaskId=" + userTaskId + "]";
    }
}