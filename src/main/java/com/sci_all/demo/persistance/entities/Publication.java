package com.sci_all.demo.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "publications", schema = "sci_db", indexes = {
        @Index(name = "author", columnList = "author")
})
public class Publication {
    @Id
    @Column(name = "publication_id", nullable = false)
    private Long id;

    @Size(max = 36)
    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "publication_uuid", nullable = false, length = 36)
    private UUID uuid;

    @Size(max = 255)
    @Column(name = "body")
    private String body;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author", nullable = false)
    private User author;

    @Column(name = "deleted_at")
    private LocalDate deletedAt;

}