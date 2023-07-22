package com.imovies.onboard.resource.show.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Accessors(chain = true)
@Table(name = "show_calendar_seat_booking")
public class ShowCalendarSeatBooking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SHOW_CALENDAR_ID", nullable = false)
    private Integer showCalendarId;

    @Column(name = "SEAT_ID", nullable = false)
    private Integer seatId;

    @Column(name = "SEAT_STATUS", nullable = false)
    private String seatStatus;

    @Column(name = "BOOKING_ID", nullable = false)
    private Integer bookingId;

    @Column(name = "CREATED_TS", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTs;

    @Column(name = "UPDATED_TS", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedTs = LocalDateTime.now();

}
