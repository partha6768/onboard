package com.imovies.onboard.resource.screen.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class ScreenPk implements Serializable {
    private String name;
    private Integer theaterId;

}
