package ru.timofeev.project_developing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "task_status")
@Getter
@Setter
public class TaskStatus {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "percentage_of_done")
    private Long percentageOfDone;
}
