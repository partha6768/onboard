package com.imovies.onboard.resource.booking.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


@Data
public class BookingVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "userId can not null")
    private String userId;

    @NotNull(message = "showId can not null")
    private Integer showId;

    @NotNull(message = "showCalendarId can not null")
    private Integer showCalendarId;

    @NotNull(message = "screenSeatTypeId can not null")
    private Integer screenSeatTypeId;

    @NotNull(message = "numberOfTicket can not null")
    private Integer numberOfTicket;

    @NotNull(message = "unitPrice can not null")
    private Double unitPrice;

    @NotNull(message = "totalPrice can not null")
    private Double totalPrice;

    @NotNull(message = "priceBeforeTax can not null")
    private Double priceBeforeTax;

    @NotNull(message = "gst can not null")
    private Double gst;

    @NotNull(message = "cgst can not null")
    private Double cgst;

    @NotNull(message = "sgst can not null")
    private Double sgst;

    @NotNull(message = "seatIds can not null")
    @Size(min = 1)
    private Set<Integer> seatIds;

}
