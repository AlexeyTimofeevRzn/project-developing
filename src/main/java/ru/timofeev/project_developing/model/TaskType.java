package ru.timofeev.project_developing.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_type")
public class TaskType {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "complexity")
    private Long complexity;
}
