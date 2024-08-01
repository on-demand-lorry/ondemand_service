package com.ondemand.business.service.controller;

import com.ondemand.business.service.constant.Constant;
import com.ondemand.business.service.constant.DBConstant;
import com.ondemand.business.service.constant.MessageConstant;
import com.ondemand.business.service.dto.CommonResponseDTO;
import com.ondemand.business.service.dto.ServiceTypeResponseDTO;
import com.ondemand.business.service.service.OnDemandServiceTypeService;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/ondemand/service"})
public class ServiceTypeController extends BaseController {

    @Autowired
    OnDemandServiceTypeService onDemandServiceTypeService;

    @GetMapping("/all")
    public CommonResponseDTO getAllCategory() {

        onDemandServiceTypeService.getAllCetagory();
        return CommonResponseDTO.builder().status(Constant.Status.SUCCESS).message(MessageConstant.ALL_CATEGORY_DETAILS).data(null).build();
    }

    @GetMapping
    public CommonResponseDTO getCategory(@RequestParam(value = "category",required = true) String category ) {

       ServiceTypeResponseDTO serviceTypeResponseDTO= onDemandServiceTypeService.getCategory(category);
        return CommonResponseDTO.builder().status(Constant.Status.SUCCESS).message(MessageConstant.CATEGORY_DETAILS).data(serviceTypeResponseDTO).build();

    }
}
