package com.imovies.onboard.resource.show.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ShowCalendarQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer showId;

    private LocalDate showRunDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

}
