package com.sci_all.demo.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "publication_resources", schema = "sci_db", indexes = {
        @Index(name = "publication", columnList = "publication"),
        @Index(name = "resource", columnList = "resource")
})
public class PublicationResource {
    @Id
    @Column(name = "publication_resource_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publication")
    private Publication publication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource")
    private Resource resource;

}