package com.codesnippet.application_management_system.controllers;

import com.codesnippet.application_management_system.Entity.Resume;
import com.codesnippet.application_management_system.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ResumeController {

    private ResumeService resumeService;

    public ResumeController(ResumeService resumeService){
        this.resumeService=resumeService;
    }

    @PostMapping("/{applicantId}/resume")
     public ResponseEntity<Resume> addResume(@PathVariable Long applicantId, @RequestBody Resume resume){
        return ResponseEntity.ok(resumeService.addResume(applicantId,resume));
     }


}
