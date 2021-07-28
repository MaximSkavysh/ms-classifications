package com.lobster.data.jpa.entity;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;


@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Audit {

    @CreatedDate
    @Column(name = "date_created")
    private Long dateCreated;

    @LastModifiedDate
    @Column(name = "date_updated")
    private Long dateUpdated;

}