package com.sci_all.demo.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "resources", schema = "sci_db")
public class Resource {
    @Id
    @Column(name = "resource_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "resource_uuid", nullable = false, length = 36)
    private String uuid;

    @Size(max = 255)
    @NotNull
    @Column(name = "resource_url", nullable = false)
    private String resourceUrl;

    @Size(max = 255)
    @Column(name = "resource_type")
    private String resourceType;

}