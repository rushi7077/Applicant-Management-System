package com.codesnippet.application_management_system.service;

import com.codesnippet.application_management_system.Entity.Applicant;
import com.codesnippet.application_management_system.Entity.Job;
import com.codesnippet.application_management_system.repositories.ApplicantJpaRepository;
import com.codesnippet.application_management_system.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {

    private JobRepository jobRepository;
    private ApplicantJpaRepository applicantJpaRepository;

    public JobService(JobRepository jobRepository,ApplicantJpaRepository applicantJpaRepository){
        this.jobRepository=jobRepository;
        this.applicantJpaRepository=applicantJpaRepository;
    }

    public Job createJob(Job job){
        return jobRepository.save(job);
    }

    public Applicant addJobToApplicant (Long applicantId,Long jobId){
        Optional<Applicant> applicant=applicantJpaRepository.findById(applicantId);
        Optional<Job> job = jobRepository.findById(jobId);

        if(applicant.isPresent() && job.isPresent()){
            applicant.get().getJobs().add(job.get());
            applicantJpaRepository.save(applicant.get());
            return applicant.get();
        }else{
            throw new IllegalArgumentException("Applicant or job not found");
        }
    }

}
