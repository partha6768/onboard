package com.imovies.onboard.resource.movie.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class MovieViewTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "viewTypeName can not null")
    private String viewTypeName;

    @NotNull(message = "languageName can not null")
    private String languageName;

}
