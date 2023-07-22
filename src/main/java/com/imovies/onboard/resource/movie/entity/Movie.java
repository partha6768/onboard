package com.imovies.onboard.resource.movie.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "movie")
public class Movie  {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "MOVIE_TYPE_NAME", nullable = false)
    private String movieTypeName;

    @Column(name = "DURATION", nullable = false)
    private String duration;

    @Column(name = "RELEASE_TS", nullable = false)
    private LocalDateTime releaseTs;

    @Column(name = "GENERE", nullable = false)
    private String genere;

    @Column(name = "THUMBNAIL_URL", nullable = false)
    private String thumbnailUrl;

    @Column(name = "TRAILER_URL", nullable = false)
    private String trailerUrl;

    @Column(name = "CREATED_TS", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTs;

    @Column(name = "UPDATED_TS", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedTs;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")
    private List<MovieViewType> movieViewTypes = new ArrayList<>();

}
