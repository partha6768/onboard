package com.imovies.onboard.resource.viewtype;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ViewTypeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    private LocalDateTime createdAt;

}
