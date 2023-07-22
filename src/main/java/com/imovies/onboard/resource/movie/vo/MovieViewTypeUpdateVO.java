package com.imovies.onboard.resource.movie.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class MovieViewTypeUpdateVO extends MovieViewTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
