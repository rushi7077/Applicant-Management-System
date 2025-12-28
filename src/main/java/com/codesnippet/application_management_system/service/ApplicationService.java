package com.codesnippet.application_management_system.service;

import com.codesnippet.application_management_system.Entity.Applicant;
import com.codesnippet.application_management_system.Entity.Application;
import com.codesnippet.application_management_system.repositories.ApplicantJpaRepository;
import com.codesnippet.application_management_system.repositories.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicantJpaRepository applicantJpaRepository;
    private ApplicationRepository applicationRepository;

     public ApplicationService(ApplicationRepository applicationRepository, ApplicantJpaRepository applicantJpaRepository){
         this.applicationRepository=applicationRepository;
         this.applicantJpaRepository=applicantJpaRepository;
     }

     public Application saveApplcation(Long applicantId,Application application){

         Optional<Applicant> applicantOptional = applicantJpaRepository.findById(applicantId);
         if (applicantOptional .isPresent()){
             Applicant applicant =applicantOptional.get();
             application.setApplicant(applicant);
             return applicationRepository.save(application);
         }
         else{
             throw new RuntimeException("Applicant not found with this id " + applicantId);
         }

     }

}
