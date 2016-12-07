package com.todoapp.model;

public class UserTask {

    private String startTime;
    private String endTime;
    private String description;
    private int userTaskId;

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
        return "UserTask [startTime=" + startTime + ", endTime=" + endTime + ", description=" + description
                + ", userTaskId=" + userTaskId + "]";
    }

}
