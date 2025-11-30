package com.codesnippet.application_management_system.service;

import com.codesnippet.application_management_system.Entity.Applicant;
import com.codesnippet.application_management_system.Entity.Resume;
import com.codesnippet.application_management_system.repositories.ApplicantCrudRepository;
import com.codesnippet.application_management_system.repositories.ApplicantJpaRepository;
import com.codesnippet.application_management_system.repositories.ApplicantPagingAndSortingRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantCrudRepository applicantCrudRepository;
    private final ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository;
    private final ApplicantJpaRepository applicantJpaRepository;

    public ApplicantService(ApplicantCrudRepository applicantCrudRepository,
                            ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository,
                            ApplicantJpaRepository applicantJpaRepository) {

        this.applicantCrudRepository = applicantCrudRepository;
        this.applicantPagingAndSortingRepository = applicantPagingAndSortingRepository;
        this.applicantJpaRepository = applicantJpaRepository;
    }

    // 🔹 Get all applicants (CRUD Repository)
    public List<Applicant> getAllApplicants() {
        return applicantCrudRepository.findAll();
    }

    // 🔹 Find applicants by status and sort by name
    public List<Applicant> getApplicantByStatus(String status) {
        return applicantJpaRepository.findByStatusOrderByNameAsc(status);
    }

    // 🔹 Search applicants using partial name (custom query)
    public List<Applicant> getApplicantByPartialName(String name) {
        return applicantJpaRepository.findApplicantsByPartialName(name);
    }

    // 🔹 Save applicant + auto-manage One-to-One Resume relation
    public Applicant saveApplicantCrud(Applicant applicant) {
        Resume resume = applicant.getResume();
        if (resume != null) {
            resume.setApplicant(applicant); // maintain bidirectional relation
        }
        return applicantCrudRepository.save(applicant);
    }

    // 🔹 Pagination using PagingAndSorting repo
    public Iterable<Applicant> getApplicantsWithPagination(int page, int size) {
        return applicantPagingAndSortingRepository.findAll(PageRequest.of(page, size));
    }
}
