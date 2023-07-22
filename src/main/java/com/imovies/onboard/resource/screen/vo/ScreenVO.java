package com.imovies.onboard.resource.screen.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;


@Data
public class ScreenVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "theaterId can not null")
    private Integer theaterId;

    @NotNull(message = "viewTypeName can not null")
    private String viewTypeName;

    @NotNull(message = "audioTypeName can not null")
    private String audioTypeName;

    @NotNull(message = "Seat Types can not ne null")
    @Size(min = 1)
    private Set<ScreenSeatTypeVO> screenSeatTypes;

}
