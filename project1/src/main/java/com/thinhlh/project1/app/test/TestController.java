package com.thinhlh.project1.app.test;

import com.thinhlh.project1.base.BaseController;
import com.thinhlh.project1.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController extends BaseController {

    private final Props props;

    @GetMapping("/user")
    private ResponseEntity<BaseResponse<Props>> getUser() {
//        LoggerFactory.getLogger(TestController.class).info(props.toString());
        return successResponse(props);
    }
}
