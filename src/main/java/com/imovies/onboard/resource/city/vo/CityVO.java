package com.imovies.onboard.resource.city.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class CityVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "state can not null")
    private String state;

    @NotNull(message = "country can not null")
    private String country;

    @NotNull(message = "active can not null")
    private Integer active;

}
