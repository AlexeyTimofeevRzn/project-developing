package ru.timofeev.project_developing.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {

    private Long id;

    private String login;

    private String password;

    private String name;

    private String surname;

    private Date birthDate;
}
