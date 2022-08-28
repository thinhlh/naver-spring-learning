package com.thinhlh.btvn14.app.factory.controller;

import com.thinhlh.btvn14.app.factory.domain.entities.Computer;
import com.thinhlh.btvn14.app.factory.data.repositories.ComputerFactory;
import com.thinhlh.btvn14.app.factory.domain.services.ComputerService;
import com.thinhlh.btvn14.base.BaseController;
import com.thinhlh.btvn14.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FactoryController extends BaseController {
    private final ComputerService computerService;

    @GetMapping("/{type}")
    private ResponseEntity<BaseResponse<Computer>> getComputer(@PathVariable("type") String type) {

        Computer computer = computerService.getComputer(type);
        System.out.println("Type: " + type);
        System.out.println("Computer: " + computer.getType());

        return successResponse(computer);
    }
}
