package com.imovies.onboard.resource.city;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CityDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String name;

    private String state;

    private String country;

    private Integer active;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

}
