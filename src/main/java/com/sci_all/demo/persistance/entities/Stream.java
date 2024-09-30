package com.sci_all.demo.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

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
    @Column(name = "stream_uuid", nullable = false, length = 36)
    private String streamUuid;

    @Size(max = 36)
    @Column(name = "stream_token", length = 36)
    private String streamToken;

    @Column(name = "viewers_count")
    private Long viewersCount;

    @Column(name = "likes_count")
    private Integer likesCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publication")
    private Publication publication;

}