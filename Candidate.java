package com.smarthire.model;

import java.sql.Timestamp;

public class Candidate {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String skills;
    private int experienceYears;
    private String resumePath;
    private String status;
    private int appliedJobId;
    private String appliedJobTitle; // Helper field for dashboard UI
    private Timestamp createdAt;

    public Candidate() {}

    public Candidate(int id, String name, String email, String phone, String skills, int experienceYears, 
                     String resumePath, String status, int appliedJobId, String appliedJobTitle, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
        this.experienceYears = experienceYears;
        this.resumePath = resumePath;
        this.status = status;
        this.appliedJobId = appliedJobId;
        this.appliedJobTitle = appliedJobTitle;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAppliedJobId() {
        return appliedJobId;
    }

    public void setAppliedJobId(int appliedJobId) {
        this.appliedJobId = appliedJobId;
    }

    public String getAppliedJobTitle() {
        return appliedJobTitle;
    }

    public void setAppliedJobTitle(String appliedJobTitle) {
        this.appliedJobTitle = appliedJobTitle;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
