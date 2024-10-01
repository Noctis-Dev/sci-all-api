package com.sci_all.demo.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comments", schema = "sci_db", indexes = {
        @Index(name = "author", columnList = "author"),
        @Index(name = "publication", columnList = "publication"),
        @Index(name = "stream", columnList = "stream")
})
public class Comment {
    @Id
    @Column(name = "comment_id", nullable = false)
    private Long id;

    @Size(max = 36)
    @NotNull
    @Column(name = "comment_uuid", nullable = false, length = 36)
    private String uuid;

    @Size(max = 255)
    @Column(name = "body")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publication")
    private Publication publication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stream")
    private Stream stream;

}