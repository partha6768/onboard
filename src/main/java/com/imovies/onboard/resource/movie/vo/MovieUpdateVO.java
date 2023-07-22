package com.imovies.onboard.resource.movie.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class MovieUpdateVO extends MovieVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
