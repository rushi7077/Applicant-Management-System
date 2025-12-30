package com.codesnippet.application_management_system.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;

    @ManyToMany(mappedBy = "jobs")
    private List<Applicant> applicants=new ArrayList<>();
}
