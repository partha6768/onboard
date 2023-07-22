package com.imovies.onboard.resource.show.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ShowQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer movieId;

    private String movieTitle;

    private String genere;

    private String languageName;

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

}
