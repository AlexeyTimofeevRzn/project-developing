package ru.timofeev.project_developing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "company_position")
@Entity
public class CompanyPosition {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "task_complexity")
    private Long taskComplexity;
}
