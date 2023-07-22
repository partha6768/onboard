package com.imovies.onboard.resource.user.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private String id;

    @NotNull(message = "name can not null")
    private String name;

    @NotNull(message = "userTypeName can not null")
    private String userTypeName;

    @NotNull(message = "email can not null")
    private String email;

    @NotNull(message = "mobile can not null")
    private String mobile;

    @NotNull(message = "active can not null")
    private Integer active;
}
