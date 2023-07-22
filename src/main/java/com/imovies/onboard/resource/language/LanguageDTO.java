package com.imovies.onboard.resource.language;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class LanguageDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    private LocalDateTime createdAt;

}
