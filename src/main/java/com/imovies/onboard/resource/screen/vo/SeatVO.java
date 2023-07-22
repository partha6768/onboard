package com.imovies.onboard.resource.screen.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class SeatVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "rowNum can not null")
    private Integer rowNum;

    @NotNull(message = "columnNum can not null")
    private Integer columnNum;

    private Boolean space;
}
