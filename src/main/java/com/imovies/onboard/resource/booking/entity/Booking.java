package com.imovies.onboard.resource.booking.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "booking")
@Accessors(chain = true)
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Column(name = "SHOW_ID", nullable = false)
    private Integer showId;

    @Column(name = "SHOW_CALENDAR_ID", nullable = false)
    private Integer showCalendarId;

    @Column(name = "SCREEN_SEAT_TYPE_ID", nullable = false)
    private Integer screenSeatTypeId;

    @Column(name = "NUMBER_OF_TICKET", nullable = false)
    private Integer numberOfTicket;

    @Column(name = "UNIT_PRICE", nullable = false)
    private Double unitPrice;

    @Column(name = "TOTAL_PRICE", nullable = false)
    private Double totalPrice;

    @Column(name = "PRICE_BEFORE_TAX", nullable = false)
    private Double priceBeforeTax;

    @Column(name = "GST", nullable = false)
    private Double gst;

    @Column(name = "CGST", nullable = false)
    private Double cgst;

    @Column(name = "SGST", nullable = false)
    private Double sgst;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "PAYMENT_TRANSACTION_ID")
    private String paymentTransactionId;

    @Column(name = "CREATED_TS", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTs;

    @Column(name = "UPDATED_TS", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedTs = LocalDateTime.now();

}
