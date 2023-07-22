package com.imovies.onboard.resource.show.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


@Data
public class ShowCalendarVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "showRunDate can not null")
    private LocalDate showRunDate;

    @NotNull(message = "startTime can not null")
    private LocalDateTime startTime;

    @NotNull(message = "endTime can not null")
    private LocalDateTime endTime;

    @NotNull(message = "createdTs can not null")
    @Size(min = 1)
    private Set<ShowCalendarPriceVO> showCalendarPrices;

}
