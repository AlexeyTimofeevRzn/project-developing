package ru.timofeev.project_developing.model;

import jakarta.persistence.*;
import lombok.*;
import ru.timofeev.project_developing.enums.ProjectStatus;

import java.sql.Date;

@Table(name = "projects")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date_of_start")
    private Date dateOfStart;

    @Column(name = "fact_date_of_end")
    private Date factDateOfEnd;

    @Column(name = "planned_date_of_end")
    private Date plannedDateOfEnd;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ProjectStatus status;

//    @Column(name = "type")
//    @Enumerated(value = EnumType.STRING)
//    private ProjectType type;

    @ManyToOne
    @JoinColumn(name = "project_type", nullable = true)
    private ProjectType type;

    @Column(name = "planned_payload")
    private Long plannedPayload;

    @Column(name = "fact_payload")
    private Long factPayload;

    @Column(name = "responsible_login")
    private String responsibleLogin;
}
