package com.sci_all.demo.persistance.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role", schema = "sci_db")
public class Role {
    @Id
    @Column(name = "role_id", nullable = false)
    private Long id;

    @Size(max = 36)
    @NotNull
    @Column(name = "role_uuid", nullable = false, length = 36)
    private String roleUuid;

    @Size(max = 20)
    @NotNull
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

}