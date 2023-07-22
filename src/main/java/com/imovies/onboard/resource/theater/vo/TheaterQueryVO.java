package com.imovies.onboard.resource.theater.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TheaterQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String displayName;

    private String vendorId;

    private Integer cityId;

    private String address;

    private String latitude;

    private String longitude;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

}
