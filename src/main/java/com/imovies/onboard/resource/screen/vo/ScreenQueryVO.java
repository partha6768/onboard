package com.imovies.onboard.resource.screen.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ScreenQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private Integer theaterId;

    private String viewTypeName;

    private String audioTypeName;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

}
