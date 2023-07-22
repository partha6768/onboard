package com.imovies.onboard.resource.usertype.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserTypeUpdateVO extends UserTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
