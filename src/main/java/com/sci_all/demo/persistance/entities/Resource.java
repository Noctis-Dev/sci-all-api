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
@Table(name = "resources", schema = "sci_db")
public class Resource {
    @Id
    @Column(name = "resource_id", nullable = false)
    private Long id;

    @Size(max = 36)
    @NotNull
    @Column(name = "resource_uuid", nullable = false, length = 36)
    private String resourceUuid;

    @Size(max = 255)
    @NotNull
    @Column(name = "resource_url", nullable = false)
    private String resourceUrl;

    @Size(max = 255)
    @Column(name = "resource_type")
    private String resourceType;

}