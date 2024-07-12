package com.ondemand.business.service.controller;

import com.ondemand.business.service.dto.CommonResponseDTO;
import com.ondemand.business.service.service.OnDemandServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("ondemand/service")
public class ServiceTypeController extends BaseController {

    @Autowired
    OnDemandServiceTypeService onDemandServiceTypeService;

    @GetMapping(value = {"/{category}"})
    public CommonResponseDTO getCategory(@PathVariable("category") String category ) {

        onDemandServiceTypeService.getCategory(category);
        return  null;
    }
}
