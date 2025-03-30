package ru.timofeev.project_developing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectType {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "priority")
    private String priority;
}
