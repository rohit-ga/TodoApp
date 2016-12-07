package com.todoapp.model;

public class UserTaskDto {

    private String userFname;
    private String startTime;
    private String endTime;
    private String description;

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
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
        return "UserTaskDto [userFname=" + userFname + ", startTime=" + startTime + ", endTime=" + endTime
                + ", description=" + description + "]";
    }
}
