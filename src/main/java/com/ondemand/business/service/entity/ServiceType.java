package com.ondemand.business.service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table
@Data
public class ServiceType {
    @Id
    @Column
    private String category;

    @Column
    private String categoryDescription;

    @Column
    private Integer level;

    @Column
    private Integer group;

    @Column
    private Integer parentGroup;

    @Column
    private Integer order;

    @ManyToOne//(optional=false)
    @JoinColumn(name = "parent_category", nullable = true)
    private ServiceType parentCategory;

    @Column
    private String logo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status", nullable = false)
    private Status status;

    @Column(insertable = false, updatable = false)
    private Timestamp createdTime;

    @Column(insertable = false, updatable = false)
    private Timestamp updatedTime;

}
