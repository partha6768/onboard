package com.imovies.onboard.resource.audiotype.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class AudioTypeUpdateVO extends AudioTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
