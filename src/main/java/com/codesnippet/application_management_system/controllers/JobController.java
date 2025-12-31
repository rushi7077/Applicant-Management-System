package com.codesnippet.application_management_system.controllers;

import com.codesnippet.application_management_system.Entity.Applicant;
import com.codesnippet.application_management_system.Entity.Job;
import com.codesnippet.application_management_system.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService){
        this.jobService=jobService;
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job){
        Job createJobs = jobService.createJob(job);
        return ResponseEntity.ok(createJobs);
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Job> getJobById(@PathVariable Long id ){
        Job job=jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }
    @PostMapping("/add-job-to-applicant")
    public ResponseEntity<Applicant> addJobToApplicant(@RequestParam Long applicantId,@RequestParam Long jobId){
        Applicant updatedApplicant = jobService.addJobToApplicant(applicantId,jobId);
        return ResponseEntity.ok(updatedApplicant);
    }


}
