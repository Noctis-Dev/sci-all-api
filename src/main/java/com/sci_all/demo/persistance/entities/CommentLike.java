package com.sci_all.demo.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment_likes", schema = "sci_db", indexes = {
        @Index(name = "author", columnList = "author"),
        @Index(name = "stream", columnList = "stream")
})
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id", nullable = false)
    private Long id;

    @Size(max = 36)
    @NotNull
    @Column(name = "like_uuid", nullable = false, length = 36)
    private String likeUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stream")
    private Stream stream;

}