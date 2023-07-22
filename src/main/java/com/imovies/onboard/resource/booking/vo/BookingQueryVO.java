package com.imovies.onboard.resource.booking.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BookingQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userId;

    private Integer showId;

    private Integer showCalendarId;

    private Integer screenSeatTypeId;

    private Integer numberOfTicket;

    private Double unitPrice;

    private Double totalPrice;

    private Double priceBeforeTax;

    private Double gst;

    private Double cgst;

    private Double sgst;

    private String status;

    private String paymentTransactionId;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

}
