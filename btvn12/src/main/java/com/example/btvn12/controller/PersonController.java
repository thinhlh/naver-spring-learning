package com.example.btvn12.controller;

import com.example.btvn12.base.BaseController;
import com.example.btvn12.base.BaseResponse;
import com.example.btvn12.data.service.PersonServiceImpl;
import com.example.btvn12.domain.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController extends BaseController {

    @Autowired
    private PersonServiceImpl personService;


    @GetMapping("/api/people")
    private ResponseEntity<BaseResponse<List<Person>>> getPeopleAPI() {
        return successResponse(personService.getPeopleSortedByAgeDesc());
    }

    @GetMapping("/people")
    private String getPeopleTemplate(Model model) {
        model.addAttribute("people", personService.getPeopleSortedByAgeDesc());
        return "people";
    }
}
