package com.sci_all.demo.persistance.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "credentials", schema = "sci_db")
public class Credential {
    @Id
    @Column(name = "credential_id", nullable = false)
    private Long id;

    @Size(max = 36)
    @NotNull
    @Column(name = "credential_uuid", nullable = false, length = 36)
    private String credentialUuid;

    @Size(max = 50)
    @NotNull
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Size(max = 12)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 50)
    private String phoneNumber;

    @Size(max = 50)
    @NotNull
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @ColumnDefault("0")
    @Column(name = "verified")
    private Boolean verified;

    @Size(max = 36)
    @NotNull
    @Column(name = "verify_token", nullable = false, length = 36)
    private String verifyToken;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

}