package com.lobster.data.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;


@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit {

    @CreatedDate
    @Column(name = "date_created")
    private Long dateCreated;

    @LastModifiedDate
    @Column(name = "date_updated")
    private Long dateUpdated;

    @CreatedBy
    private String createdBy;

}
