package com.imovies.onboard.resource.screen.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "seat")
@Accessors(chain = true)
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "SCREEN_SEAT_TYPE_ID", nullable = false)
//    private Integer screenSeatTypeId;

    @Column(name = "ROW_NUM", nullable = false)
    private Integer rowNum;

    @Column(name = "COLUMN_NUM", nullable = false)
    private Integer columnNum;

    @Column(name = "IS_SPACE")
    private Boolean space = false;

    @Column(name = "CREATED_TS", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTs;

    @Column(name = "UPDATED_TS", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedTs = LocalDateTime.now();

}
