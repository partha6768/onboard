package com.imovies.onboard.resource.movie.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Data
public class MovieVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "title can not null")
    private String title;

    @NotNull(message = "description can not null")
    private String description;

    @NotNull(message = "movieTypeName can not null")
    private String movieTypeName;

    @NotNull(message = "duration can not null")
    private String duration;

    @NotNull(message = "releaseTs can not null")
    private LocalDateTime releaseTs;

    @NotNull(message = "genere can not null")
    private String genere;

    @NotNull(message = "thumbnailUrl can not null")
    private String thumbnailUrl;

    @NotNull(message = "trailerUrl can not null")
    private String trailerUrl;

    @NotNull
    @Size(min = 1)
    private List<MovieViewTypeVO> movieViewType;

}
