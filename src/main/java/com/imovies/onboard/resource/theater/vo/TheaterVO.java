package com.imovies.onboard.resource.theater.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class TheaterVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "name can not null or empty")
    private String name;

    @NotEmpty(message = "displayName can not null or empty")
    private String displayName;

    @NotEmpty(message = "vendorId can not null or empty")
    private String vendorId;

    @NotNull(message = "cityId can not null")
    private Integer cityId;

    @NotNull(message = "address can not null")
    private String address;

    @NotEmpty(message = "latitude can not null or empty")
    private String latitude;

    @NotEmpty(message = "longitude can not null or empty")
    private String longitude;

}
