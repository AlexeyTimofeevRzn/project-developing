package ru.timofeev.project_developing.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

    private String code;

    private String name;

    private String description;

    private String dateOfStart;

    private String plannedDateOfEnd;

    private String status;

    private String type;

    private Long plannedPayload;

    private String responsibleLogin;
}
