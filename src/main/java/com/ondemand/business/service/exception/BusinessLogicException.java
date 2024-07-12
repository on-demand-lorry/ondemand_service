package com.ondemand.business.service.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

public class BusinessLogicException extends BindException {

    public BusinessLogicException(BindingResult bindingResult) {
        super(bindingResult);
    }
}
