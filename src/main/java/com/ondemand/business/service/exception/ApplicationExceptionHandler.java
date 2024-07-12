package com.ondemand.business.service.exception;


import com.ondemand.business.service.constant.Constant;
import com.ondemand.business.service.dto.CommonResponseDTO;
import com.ondemand.business.service.model.FieldError;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.NodeImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
@Slf4j
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                               HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, List<FieldError>> fieldErrors = new HashMap<>();
        fieldErrors.put("errors", this.processFieldErrors(exception.getFieldErrors()));
        CommonResponseDTO response = CommonResponseDTO.builder()
                .status(Constant.Status.ERROR)
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .data(fieldErrors)
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private List<FieldError> processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
        List<FieldError> errors = new ArrayList<>();
        for (org.springframework.validation.FieldError fieldError : fieldErrors) {
            FieldError error = FieldError.builder().field(fieldError.getField()).message(fieldError.getDefaultMessage()).build();
            errors.add(error);
        }

        return errors;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception, WebRequest request) {
        ConstraintViolation<?> constraintViolation = exception.getConstraintViolations().stream().toList().getFirst();
        Path path = constraintViolation.getPropertyPath();
        CommonResponseDTO response = CommonResponseDTO.builder()
                .status(Constant.Status.ERROR)
                .data(null)
                .message(((NodeImpl) ((PathImpl) path).getLeafNode()) + " : " + constraintViolation.getMessageTemplate())
                .build();


        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException exception, WebRequest request) {
        CommonResponseDTO response = CommonResponseDTO.builder()
                .status(Constant.Status.ERROR)
                .data(null)
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

   /* @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        log.error(exception.toString(), exception);
        Response response = Response.builder()
                .status(ApplicationConstant.STATUS_ERROR)
                .data(null)
                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()) //exception.getMessage()
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    @ExceptionHandler(ArgumentException.class)
    public ResponseEntity<Object> handleArgumentException(ArgumentException argumentException) {

        CommonResponseDTO response = CommonResponseDTO.builder()
                .status(Constant.Status.ERROR)
                .data(argumentException.getMessage())
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase()) //exception.getMessage()
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Object> handleForbiddenException(ForbiddenException forbiddenException) {
        CommonResponseDTO response = CommonResponseDTO.builder()
                .status(Constant.Status.ERROR)
                .data(forbiddenException.getMessage())
                .message(HttpStatus.FORBIDDEN.getReasonPhrase()) //exception.getMessage()
                .build();

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<Object> handleBusinessLogicException(BusinessLogicException businessLogicException) {
        BindingResult bindingResult = businessLogicException.getBindingResult();
        Map<String, List<FieldError>> fieldErrors = new HashMap<>();
        fieldErrors.put("errors", this.processFieldErrors(bindingResult.getFieldErrors()));
        CommonResponseDTO response = CommonResponseDTO.builder()
                .status(Constant.Status.ERROR)
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .data(fieldErrors)
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
