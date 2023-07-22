package com.imovies.onboard.resource.show.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ShowCalendarPriceQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer showCalendarId;

    private Integer screenSeatTypeId;

    private Double price;

    private Double priceBeforeTax;

    private Double gst;

    private Double cgst;

    private Double sgst;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

}
