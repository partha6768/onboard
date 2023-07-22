package com.imovies.onboard.resource.screen.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class ScreenSeatTypeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String seatTypeName;
    Set<SeatDTO> seats;

}
