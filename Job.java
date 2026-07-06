package com.smarthire.model;

import java.sql.Timestamp;

public class Job {
    private int id;
    private String title;
    private String department;
    private String description;
    private String requirements;
    private String status;
    private Timestamp createdAt;

    public Job() {}

    public Job(int id, String title, String department, String description, String requirements, String status, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.description = description;
        this.requirements = requirements;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
