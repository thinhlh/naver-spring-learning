package com.thinhlh.hello_world_application.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;



public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected <T> ResponseEntity<BaseResponse<T>> successResponse(T data) {
        return ResponseEntity.ok(BaseResponse.success(data));
    }
}
