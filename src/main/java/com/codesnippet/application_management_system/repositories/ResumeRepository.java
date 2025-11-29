package com.codesnippet.application_management_system.repositories;

import com.codesnippet.application_management_system.Entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume,Long>{

}
