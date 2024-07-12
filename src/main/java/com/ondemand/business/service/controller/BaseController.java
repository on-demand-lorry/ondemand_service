package com.ondemand.business.service.controller;


import com.ondemand.business.service.dto.CommonResponseDTO;

public class BaseController {

    protected CommonResponseDTO commonResponseDTO(String status, String message, Object data) {
        return CommonResponseDTO.builder()
                .status(status).message(message).data(data).build();
    }

}
