package com.thinhlh.btvn14.config.handlers;

import com.thinhlh.btvn14.base.BaseResponse;
import com.thinhlh.btvn14.exceptions.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Current declared exceptions that are handled:
 *
 * @exception NotFoundException
 * @exception MethodArgumentNotValidException
 */

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    private ResponseEntity<BaseResponse<Object>> handleNotFoundException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(BaseResponse.error(e.getMessage()));
    }


    @ExceptionHandler(value = {Exception.class})
    private ResponseEntity<BaseResponse<Object>> handleAllException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(BaseResponse.error(e.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request
    ) {
        StringBuilder errorString = new StringBuilder();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            errorString.append(fieldName)
                    .append(": ")
                    .append(errorMessage)
                    .append(", ");
        });

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(BaseResponse.error(errorString.substring(0, errorString.length() > 2 ? errorString.length() - 2 : errorString.length())));
    }
}
