package com.imovies.onboard.resource.show.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class ShowCalendarPriceVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "screenSeatTypeId can not null")
    private Integer screenSeatTypeId;

    @NotNull(message = "price can not null")
    private Double price;

//    @NotNull(message = "priceBeforeTax can not null")
//    private Double priceBeforeTax;
//
//    @NotNull(message = "gst can not null")
//    private Double gst;
//
//    @NotNull(message = "cgst can not null")
//    private Double cgst;
//
//    @NotNull(message = "sgst can not null")
//    private Double sgst;

}
