package com.codesnippet.application_management_system.repositories;

import com.codesnippet.application_management_system.Entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
}
