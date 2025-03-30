package ru.timofeev.project_developing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee_project_role")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProjectRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private ProjectRole role;

    @ManyToOne
    @JoinColumn(name = "project_role", nullable = false)
    private ProjectRole projectRole;
}

