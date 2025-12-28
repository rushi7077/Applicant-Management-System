package com.codesnippet.application_management_system.controllers;

import com.codesnippet.application_management_system.Entity.Application;
import com.codesnippet.application_management_system.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/applications")
public class ApplicationController {

    private ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService){
        this.applicationService=applicationService;
    }

    @PostMapping("/{applicantId}")
    public ResponseEntity<Application> createApplication(@RequestBody Application application,
                                                         @PathVariable Long applicantId){
        Application savedApplication=applicationService.saveApplcation(applicantId,application);
        return ResponseEntity.ok(savedApplication);
    }

}
