package com.metro.metromilan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
