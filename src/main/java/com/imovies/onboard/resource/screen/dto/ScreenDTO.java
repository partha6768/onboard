package com.imovies.onboard.resource.screen.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ScreenDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    private Integer theaterId;

    private String viewTypeName;

    private String audioTypeName;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

    Set<ScreenSeatTypeDTO> screenSeatTypes;

}
