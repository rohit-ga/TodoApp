package com.todoapp.model;

public class UserRole {

    private int role;
    private int roleId;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole [role=" + role + ", roleId=" + roleId + "]";
    }
}
