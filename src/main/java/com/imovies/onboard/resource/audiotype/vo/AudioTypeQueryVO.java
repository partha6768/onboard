package com.imovies.onboard.resource.audiotype.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AudioTypeQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private LocalDateTime createdAt;

}
