package com.ondemand.business.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldError {

    private String field;
    private String message;

}
