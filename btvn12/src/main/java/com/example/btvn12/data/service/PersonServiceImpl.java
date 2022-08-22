package com.example.btvn12.data.service;

import com.example.btvn12.data.repository.PersonRepository;
import com.example.btvn12.domain.entity.Person;
import com.example.btvn12.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getPeopleSortedByAgeDesc() {
        return personRepository
                .getPeople()
                .stream()
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .toList();
    }
}
