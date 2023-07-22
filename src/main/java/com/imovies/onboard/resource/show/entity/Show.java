package com.imovies.onboard.resource.show.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "`show`")
@Accessors(chain = true)
public class Show implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MOVIE_ID", nullable = false)
    private Integer movieId;

    @Column(name = "MOVIE_TITLE", nullable = false)
    private String movieTitle;

    @Column(name = "GENERE", nullable = false)
    private String genre;

    @Column(name = "LANGUAGE_NAME", nullable = false)
    private String languageName;

    @Column(name = "VIEW_TYPE_NAME", nullable = false)
    private String viewTypeName;

    @Column(name = "DURATION", nullable = false)
    private String duration;

    @Column(name = "SCREEN_NAME", nullable = false)
    private String screenName;

    @Column(name = "THEATER_ID", nullable = false)
    private Integer theaterId;

    @Column(name = "THEATER_DISPLAY_NAME", nullable = false)
    private String theaterDisplayName;

    @Column(name = "CITY_ID", nullable = false)
    private Integer cityId;

    @Column(name = "START_TS", nullable = false)
    private LocalDateTime startTs;

    @Column(name = "END_TS", nullable = false)
    private LocalDateTime endTs;

    @Column(name = "CREATED_TS", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTs;

    @Column(name = "UPDATED_TS", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedTs = LocalDateTime.now();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SHOW_ID", referencedColumnName = "ID")
    private Set<ShowCalendar> showCalendars = new HashSet<>();

}
