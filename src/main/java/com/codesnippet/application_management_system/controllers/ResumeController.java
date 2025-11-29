package com.codesnippet.application_management_system.controllers;

import com.codesnippet.application_management_system.Entity.Resume;
import com.codesnippet.application_management_system.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    public ResumeController(ResumeService resumeService){
        this.resumeService=resumeService;
    }

    @PostMapping("/{applicantId}/resume")
     public ResponseEntity<Resume> addResume(@PathVariable Long appicantId, @RequestBody Resume resume){
        return ResponseEntity.ok(resumeService.addResume(appicantId,resume));
     }


}
