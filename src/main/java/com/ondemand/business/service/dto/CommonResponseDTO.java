package com.ondemand.business.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonResponseDTO {
    private String status;
    private String message;
    private Object data;
}
