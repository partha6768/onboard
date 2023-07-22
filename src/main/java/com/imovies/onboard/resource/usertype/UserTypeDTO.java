package com.imovies.onboard.resource.usertype;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserTypeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    private String businessCategory;

    private LocalDateTime createdAt;

}
