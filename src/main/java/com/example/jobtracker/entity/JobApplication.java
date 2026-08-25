package com.example.jobtracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Company is required")
    @Size(max = 100, message = "Company name must not exceed 100 characters")
    private String company;

    @NotBlank(message = "Job role is required")
    @Size(max = 100, message = "Job role must not exceed 100 characters")
    private String role;

    @NotBlank(message = "Application date is required")
    private String applicationDate;

    @NotBlank(message = "Status is required")
    private String status;

    @Size(max = 500, message = "Job URL must not exceed 500 characters")
    private String jobUrl;

    @Size(max = 100, message = "Location must not exceed 100 characters")
    private String location;

    @Size(max = 50, message = "Job type must not exceed 50 characters")
    private String jobType;

    @Size(max = 1000, message = "Notes must not exceed 1000 characters")
    private String notes;


    public JobApplication() {
    }


    public JobApplication(
            String company,
            String role,
            String applicationDate,
            String status,
            String jobUrl,
            String location,
            String jobType,
            String notes) {

        this.company = company;
        this.role = role;
        this.applicationDate = applicationDate;
        this.status = status;
        this.jobUrl = jobUrl;
        this.location = location;
        this.jobType = jobType;
        this.notes = notes;
    }


    public Long getId() {
        return id;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getJobUrl() {
        return jobUrl;
    }

    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}