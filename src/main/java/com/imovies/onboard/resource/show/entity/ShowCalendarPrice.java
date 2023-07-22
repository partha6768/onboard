package com.imovies.onboard.resource.show.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "show_calendar_price")
public class ShowCalendarPrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "SHOW_CALENDAR_ID", nullable = false)
//    private Integer showCalendarId;

    @Column(name = "SCREEN_SEAT_TYPE_ID", nullable = false)
    private Integer screenSeatTypeId;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "PRICE_BEFORE_TAX", nullable = false)
    private Double priceBeforeTax;

    @Column(name = "GST", nullable = false)
    private Double gst;

    @Column(name = "CGST", nullable = false)
    private Double cgst;

    @Column(name = "SGST", nullable = false)
    private Double sgst;

    @Column(name = "CREATED_TS", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTs;

    @Column(name = "UPDATED_TS", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedTs = LocalDateTime.now();

}
