package com.example.btvn12.domain.service;


import com.example.btvn12.domain.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPeopleSortedByAgeDesc();

}
