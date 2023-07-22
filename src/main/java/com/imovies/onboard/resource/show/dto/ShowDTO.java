package com.imovies.onboard.resource.show.dto;


import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class ShowDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer movieId;

    private String movieTitle;

    private String genre;

    private String languageName;

    private String thumbnailUrl;

    private String trailerUrl;

    private String viewTypeName;

    private String duration;

    private String screenName;

    private Integer theaterId;

    private String theaterDisplayName;

    private Integer cityId;

    private LocalDateTime startTs;

    private LocalDateTime endTs;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

    private Set<ShowCalendarDTO> showCalendars;

}
