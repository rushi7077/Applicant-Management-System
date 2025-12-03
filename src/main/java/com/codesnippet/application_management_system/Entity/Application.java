package com.codesnippet.application_management_system.Entity;

import jakarta.persistence.*;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String status;

    private String position;

    @ManyToOne
    @JoinColumn(name = "applicantId", nullable = false)
    private Applicant applicant;
}
