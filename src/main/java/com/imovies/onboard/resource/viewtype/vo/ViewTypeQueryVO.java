package com.imovies.onboard.resource.viewtype.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ViewTypeQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private LocalDateTime createdAt;

}
