package com.imovies.onboard.resource.user;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private String name;

    private String userTypeName;

    private String email;

    private String mobile;

    private Integer active;

    private LocalDateTime createdTs;

    private LocalDateTime updatedTs;

}
