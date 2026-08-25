package com.example.jobtracker.controller;

import com.example.jobtracker.entity.JobApplication;
import com.example.jobtracker.repository.JobApplicationRepository;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class JobApplicationController {

    private final JobApplicationRepository repository;


    public JobApplicationController(
            JobApplicationRepository repository) {

        this.repository = repository;
    }


    // Get all job applications
    @GetMapping
    public List<JobApplication> getAllApplications() {

        return repository.findAll();
    }


    // Add a new job application
    @PostMapping
    public ResponseEntity<JobApplication> addApplication(
            @Valid @RequestBody JobApplication application) {

        JobApplication savedApplication =
                repository.save(application);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedApplication);
    }


    // Update an existing job application
    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> updateApplication(
            @PathVariable Long id,
            @Valid @RequestBody JobApplication application) {


        JobApplication existingApplication =
                repository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Application not found"
                                )
                        );


        existingApplication.setCompany(
                application.getCompany()
        );


        existingApplication.setRole(
                application.getRole()
        );


        existingApplication.setApplicationDate(
                application.getApplicationDate()
        );


        existingApplication.setStatus(
                application.getStatus()
        );


        existingApplication.setJobUrl(
                application.getJobUrl()
        );


        existingApplication.setLocation(
                application.getLocation()
        );


        existingApplication.setJobType(
                application.getJobType()
        );


        existingApplication.setNotes(
                application.getNotes()
        );


        JobApplication updatedApplication =
                repository.save(existingApplication);


        return ResponseEntity.ok(
                updatedApplication
        );
    }


    // Delete a job application
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(
            @PathVariable Long id) {


        if (!repository.existsById(id)) {

            return ResponseEntity.notFound().build();

        }


        repository.deleteById(id);


        return ResponseEntity.noContent().build();
    }
}