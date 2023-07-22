package com.imovies.onboard.resource.screen.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SeatQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer screenSeatTypeId;

    private Integer rowNum;

    private Integer columnNum;

    private Integer space;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

}
