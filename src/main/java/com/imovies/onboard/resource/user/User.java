package com.imovies.onboard.resource.user;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user")
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "USER_TYPE_NAME", nullable = false)
    private String userTypeName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "MOBILE", nullable = false)
    private String mobile;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Integer active;

    @Column(name = "CREATED_TS", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdTs;

    @Column(name = "UPDATED_TS", nullable = false, insertable = false, updatable = false)
    private LocalDateTime updatedTs;

}
