package com.sci_all.demo.persistance.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stream_resources", schema = "sci_db", indexes = {
        @Index(name = "stream", columnList = "stream"),
        @Index(name = "resource", columnList = "resource")
})
public class StreamResource {
    @Id
    @Column(name = "stream_resource_id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stream", nullable = false)
    private Stream stream;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "resource", nullable = false)
    private Resource resource;

}