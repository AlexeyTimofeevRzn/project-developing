package ru.timofeev.project_developing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "task_type", nullable = true)
    private TaskType taskType;

    @ManyToOne
    @JoinColumn(name = "task_status", nullable = true)
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = true)
    private Project project;

    @Column(name = "fact_payload")
    private Double factPayload;

    @Column(name = "planned_payload")
    private Double plannedPayload;
}
