package com.codesnippet.application_management_system.service;

import com.codesnippet.application_management_system.Entity.Applicant;
import com.codesnippet.application_management_system.Entity.Resume;
import com.codesnippet.application_management_system.repositories.ApplicantJpaRepository;
import com.codesnippet.application_management_system.repositories.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;
    private ApplicantJpaRepository applicantJpaRepository;

    public ResumeService(ResumeRepository resumeRepository,ApplicantJpaRepository applicantJpaRepository){
        this.resumeRepository=resumeRepository;
        this.applicantJpaRepository=applicantJpaRepository;
    }

    public Resume addResume(Long applicantId, Resume resume){
        Optional <Applicant> Applicantoptional = applicantJpaRepository.findById(applicantId);
        if(Applicantoptional.isPresent()){
            Applicant applicant = Applicantoptional.get();
            resume.setApplicant(applicant);
            return resumeRepository.save(resume);
        }
        else{
            throw new RuntimeException("Applicant not found with this id"+applicantId);
        }
    }


}
