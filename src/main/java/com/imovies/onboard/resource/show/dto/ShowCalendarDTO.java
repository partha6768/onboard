package com.imovies.onboard.resource.show.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ShowCalendarDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

//    private Integer showId;

    private LocalDate showRunDate;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

//    private LocalDateTime createdTs;
//
//    private LocalDateTime updatedTs;

    private Set<ShowCalendarPriceDTO> showCalendarPrices;

    private Set<Integer> reservedSeats;
}
