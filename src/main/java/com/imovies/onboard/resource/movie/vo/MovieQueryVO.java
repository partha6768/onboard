package com.imovies.onboard.resource.movie.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MovieQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String description;

    private String movieTypeName;

    private String duration;

    private LocalDateTime releaseTs;

    private String genere;

    private String thumbnailUrl;

    private String trailerUrl;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

}
