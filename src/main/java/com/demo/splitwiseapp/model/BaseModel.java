package com.demo.splitwiseapp.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(updatable = false)
    private Date createdAt;

    @Temporal(value = TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date modifiedAt;

}


