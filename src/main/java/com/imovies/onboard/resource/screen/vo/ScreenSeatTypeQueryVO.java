package com.imovies.onboard.resource.screen.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ScreenSeatTypeQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String screenName;

    private Integer theaterId;

    private String seatTypeName;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

}
