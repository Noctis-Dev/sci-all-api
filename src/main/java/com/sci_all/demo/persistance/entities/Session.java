package com.sci_all.demo.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "sessions", schema = "sci_db", indexes = {
        @Index(name = "user", columnList = "user")
})
public class Session {
    @Id
    @Column(name = "session_id", nullable = false)
    private Long id;

    @Size(max = 36)
    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "session_uuid", nullable = false, length = 36)
    private UUID uuid;

    @ColumnDefault("0")
    @Column(name = "verified")
    private Boolean verified;

    @NotNull
    @Column(name = "createdAt", nullable = false)
    private LocalDate createdAt;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user", nullable = false)
    private User user;

}