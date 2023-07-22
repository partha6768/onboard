package com.imovies.onboard.resource.movietype.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class MovieTypeUpdateVO extends MovieTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
