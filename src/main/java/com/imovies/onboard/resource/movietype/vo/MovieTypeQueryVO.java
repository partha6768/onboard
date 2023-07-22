package com.imovies.onboard.resource.movietype.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class MovieTypeQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private LocalDateTime createdAt;

}
