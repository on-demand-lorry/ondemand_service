package com.ondemand.business.service.service;

import com.ondemand.business.service.constant.DBConstant;
import com.ondemand.business.service.constant.MessageConstant;
import com.ondemand.business.service.dto.ServiceTypeResponseDTO;
import com.ondemand.business.service.entity.ServiceType;
import com.ondemand.business.service.entity.Status;
import com.ondemand.business.service.repository.ServiceTypeRepository;
import com.ondemand.business.service.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OnDemandServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;


    @PreAuthorize("hasAuthority(T(com.ondemand.business.service.constant.DBConstant.ROLE).ADMIN.name())")
     public ServiceTypeResponseDTO getCategory(String category) {
        Optional<ServiceType> optionalServiceType = serviceTypeRepository.findByCategoryAndStatus(category, Status.builder().status(DBConstant.STATUS.ACTIVE.name()).build());
        if (optionalServiceType.isPresent()) {
          ServiceTypeResponseDTO serviceTypeResponseDTO=  (ServiceTypeResponseDTO) ModelMapperUtil.map(optionalServiceType.get(), ServiceTypeResponseDTO.class);
            return serviceTypeResponseDTO;
        } else {
            throw  new NoSuchElementException(MessageConstant.Error.CATEGORY_NOT_FOUND);
        }
    }

    public void getAllCetagory() {

    }
}
