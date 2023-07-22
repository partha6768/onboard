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
@Accessors(chain = true)
@Table(name = "screen_seat_type")
public class ScreenSeatType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "SCREEN_NAME", nullable = false)
//    private String screenName;
//
//    @Column(name = "THEATER_ID", nullable = false)
//    private Integer theaterId;

    @Column(name = "SEAT_TYPE_NAME", nullable = false)
    private String seatTypeName;

    @Column(name = "CREATED_TS", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTs;

    @Column(name = "UPDATED_TS", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedTs = LocalDateTime.now();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "SCREEN_SEAT_TYPE_ID")
    Set<Seat> seats;

}
