package com.ondemand.business.service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity(name = "user")
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;


    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status", nullable = false)
    private Status status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role", nullable = false)
    private Role role;

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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserAuth userAuth;
}
