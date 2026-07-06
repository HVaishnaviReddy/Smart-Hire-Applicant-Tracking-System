package com.smarthire.model;

import java.sql.Timestamp;

public class Interview {
    private int id;
    private int candidateId;
    private String candidateName; // Helper for dashboard view
    private int jobId;
    private String jobTitle; // Helper for dashboard view
    private Timestamp interviewDate;
    private String mode; // e.g., 'Online', 'In-Person', 'Telephone'
    private String details;
    private String status; // e.g., 'Scheduled', 'Completed', 'Cancelled'

    public Interview() {}

    public Interview(int id, int candidateId, String candidateName, int jobId, String jobTitle, 
                     Timestamp interviewDate, String mode, String details, String status) {
        this.id = id;
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.interviewDate = interviewDate;
        this.mode = mode;
        this.details = details;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Timestamp getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Timestamp interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
