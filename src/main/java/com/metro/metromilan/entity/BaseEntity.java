package com.metro.metromilan.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.OffsetDateTime;

@Data
@MappedSuperclass
public class BaseEntity {
    @Column(name = "createdAt",updatable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "UpdatedAt")
    private OffsetDateTime updatedAt;
}
