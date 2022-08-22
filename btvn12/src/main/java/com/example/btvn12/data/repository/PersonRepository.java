package com.example.btvn12.data.repository;

import com.example.btvn12.domain.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private List<Person> people = new ArrayList<>() {{
        add(new Person("Le Hoang Thinh", 21, "swimming, coding, reading"));
        add(new Person("Khalessi", 24, "reading, training"));
        add(new Person("Jon Snow", 35, "exploring, shooting"));
        add(new Person("Tywing Cannister", 28, "hunting"));
        add(new Person("Arya Stark", 12, "running, wolf training"));
    }};

    public List<Person> getPeople() {
        return people;
    }
}
