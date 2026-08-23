
package com.example.jobtracker.controller;

import com.example.jobtracker.entity.JobApplication;
import com.example.jobtracker.repository.JobApplicationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class JobApplicationController {

    private final JobApplicationRepository repository;

    public JobApplicationController(JobApplicationRepository repository) {
        this.repository = repository;
    }

    // Get all job applications
    @GetMapping
    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    // Add a new job application
    @PostMapping
    public JobApplication addApplication(@RequestBody JobApplication application) {
        return repository.save(application);
    }

    // Update an existing job application
    @PutMapping("/{id}")
    public JobApplication updateApplication(
            @PathVariable Long id,
            @RequestBody JobApplication application) {

        JobApplication existingApplication = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        existingApplication.setCompany(application.getCompany());
        existingApplication.setRole(application.getRole());
        existingApplication.setApplicationDate(application.getApplicationDate());
        existingApplication.setStatus(application.getStatus());

        existingApplication.setJobUrl(application.getJobUrl());
        existingApplication.setLocation(application.getLocation());
        existingApplication.setJobType(application.getJobType());
        existingApplication.setNotes(application.getNotes());

        return repository.save(existingApplication);
    }

    // Delete a job application
    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

