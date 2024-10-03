package com.sci_all.demo.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "streams", schema = "sci_db", indexes = {
        @Index(name = "publication", columnList = "publication")
})
public class Stream {
    @Id
    @Column(name = "stream_id", nullable = false)
    private Long id;

    @Size(max = 36)
    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "stream_uuid", nullable = false, length = 36)
    private UUID uuid;

    @Size(max = 36)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "stream_token", length = 36)
    private UUID streamToken;

    @Column(name = "viewers_count")
    private Long viewersCount;

    @Column(name = "likes_count")
    private Integer likesCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publication")
    private Publication publication;

}