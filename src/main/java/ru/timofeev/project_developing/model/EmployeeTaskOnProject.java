package ru.timofeev.project_developing.model;

import jakarta.persistence.*;

import java.sql.Date;

@Table(name = "employee_task_on_project")
@Entity
public class EmployeeTaskOnProject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_number", nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "employee_login", nullable = false)
    private Employee employee;

    @Column(name = "fact_date_of_start")
    private Date factDateOfStart;

    @Column(name = "fact_date_of_end")
    private Date factDateOfEnd;

    @Column(name = "planned_date_of_end")
    private Date plannedDateOfEnd;

    @Column(name = "fact_payload")
    private Double factPayload;

    @Column(name = "planned_payload")
    private Double plannedPayload;

    @Column(name = "status")
    private String status;
}
