package com.imovies.onboard.resource.show.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


@Data
public class ShowVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "movieId can not null")
    private Integer movieId;

    @NotNull(message = "movieTitle can not null")
    private String movieTitle;

    @NotNull(message = "genre can not null")
    private String genre;

    @NotNull(message = "languageName can not null")
    private String languageName;

    @NotNull(message = "thumbnailUrl can not null")
    private String thumbnailUrl;

    @NotNull(message = "trailerUrl can not null")
    private String trailerUrl;

    @NotNull(message = "viewTypeName can not null")
    private String viewTypeName;

    @NotNull(message = "duration can not null")
    private String duration;

    @NotNull(message = "screenName can not null")
    private String screenName;

    @NotNull(message = "theaterId can not null")
    private Integer theaterId;

    @NotNull(message = "theaterDisplayName can not null")
    private String theaterDisplayName;

    @NotNull(message = "cityId can not null")
    private Integer cityId;

    @NotNull(message = "startTs can not null")
    private LocalDateTime startTs;

    @NotNull(message = "endTs can not null")
    private LocalDateTime endTs;

    @NotNull(message = "showCalendars can not null")
    @Size(min = 1)
    private Set<ShowCalendarVO> showCalendars;

}
