package com.imovies.onboard.resource.movie.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MovieViewTypeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String viewTypeName;
    private String languageName;
}
