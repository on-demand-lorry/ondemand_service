package com.ondemand.business.service.dto;

import com.ondemand.business.service.entity.ServiceType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ServiceTypeResponseDTO {
    private String category;


    private String categoryDescription;


    private Integer level;


    private Integer group;


    private Integer parentGroup;


    private Integer order;

}
