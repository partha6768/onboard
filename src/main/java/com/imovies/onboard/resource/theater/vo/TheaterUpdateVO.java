package com.imovies.onboard.resource.theater.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class TheaterUpdateVO extends TheaterVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
