package com.imovies.onboard.resource.movie.dto;


import com.imovies.onboard.resource.movie.dto.MovieViewTypeDTO;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class MovieDTO implements Serializable {
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

    private List<MovieViewTypeDTO> movieViewType;
}
