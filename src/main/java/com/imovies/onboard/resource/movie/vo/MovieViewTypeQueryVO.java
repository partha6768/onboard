package com.imovies.onboard.resource.movie.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MovieViewTypeQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer movieId;

    private String viewTypeName;

    private String languageName;

    private LocalDateTime createdTs;

}
