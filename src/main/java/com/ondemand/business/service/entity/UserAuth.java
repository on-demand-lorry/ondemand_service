package com.ondemand.business.service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table
public class UserAuth {

    @Id
    @Column(name = "user_id")
    private Integer id;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column
    private Long mobileNumber;

    @Column
    private String emailId;

    @Column
    private String password;

    @Column
    private  String agencyLicenceNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status", nullable = false)
    private Status status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id", insertable = true, updatable = false)
    private User createdBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id", nullable = true, insertable = false, updatable = true)
    private User updatedBy;

    @Column(insertable = false, updatable = false)
    private Timestamp createdTime;

    @Column(insertable = false, updatable = false)
    private Timestamp updatedTime;


}
