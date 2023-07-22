package com.imovies.onboard.resource.screen.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SeatDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer rowNum;
    private Integer columnNum;
    private Integer space;

}
