package ru.timofeev.project_developing.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthdate")
    private Date birthDate;

//    @Column(name = "company_position")
//    @Enumerated(EnumType.STRING)
//    private CompanyPosition position;

    @ManyToOne
    @JoinColumn(name = "company_position", nullable = true)
    private CompanyPosition position;
}
