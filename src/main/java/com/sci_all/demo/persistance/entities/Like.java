package com.sci_all.demo.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "likes", schema = "sci_db", indexes = {
        @Index(name = "user_id", columnList = "user_id"),
        @Index(name = "publication", columnList = "publication"),
        @Index(name = "stream", columnList = "stream")
})
public class Like {
    @Id
    @Column(name = "like_id", nullable = false)
    private Long id;

    @Size(max = 36)
    @NotNull
    @Column(name = "like_uuid", nullable = false, length = 36)
    private String likeUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publication")
    private Publication publication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stream")
    private Stream stream;

}