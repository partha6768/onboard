package com.imovies.onboard.resource.user.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserUpdateVO extends UserVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
