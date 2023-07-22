package com.imovies.onboard.resource.screen.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;


@Data
public class ScreenSeatTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "seatTypeName can not null")
    private String seatTypeName;

    @NotNull(message = "Seats can not null")
    @Size(min = 1)
    private Set<SeatVO> seats;

}
