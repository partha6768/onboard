package com.imovies.onboard.resource.movie.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "movie_view_type")
public class MovieViewType {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "VIEW_TYPE_NAME", nullable = false)
    private String viewTypeName;

    @Column(name = "LANGUAGE_NAME", nullable = false)
    private String languageName;

    @Column(name = "CREATED_TS", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdTs;

}
