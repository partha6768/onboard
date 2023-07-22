package com.imovies.onboard.resource.usertype;

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
@Accessors(chain = true)
@Table(name = "user_type")
public class UserType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "BUSINESS_CATEGORY", nullable = false)
    private String businessCategory;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

}
