package com.imovies.onboard.resource.screen.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "screen")
@IdClass(ScreenPk.class)
@Accessors(chain = true)
public class Screen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NAME", nullable = false)
    private String name;

    @Id
    @Column(name = "THEATER_ID", nullable = false)
    private Integer theaterId;

    @Column(name = "VIEW_TYPE_NAME", nullable = false)
    private String viewTypeName;

    @Column(name = "AUDIO_TYPE_NAME", nullable = false)
    private String audioTypeName;

    @Column(name = "CREATED_TS", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTs;

    @Column(name = "UPDATED_TS", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedTs = LocalDateTime.now();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "SCREEN_NAME", referencedColumnName = "NAME"), @JoinColumn(name = "THEATER_ID", referencedColumnName = "THEATER_ID")})
    Set<ScreenSeatType> screenSeatTypes;

}
