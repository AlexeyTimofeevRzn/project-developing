package ru.timofeev.project_developing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "project_role")
@Entity
public class ProjectRole {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "percentage_of_up")
    private Long percentageOfUp;
}
