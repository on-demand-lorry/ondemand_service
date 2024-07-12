package com.ondemand.business.service.repository;

import com.ondemand.business.service.entity.ServiceType;
import com.ondemand.business.service.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType,String> {
    Optional<ServiceType> findByCategoryAndStatus(String category, Status status);
}
