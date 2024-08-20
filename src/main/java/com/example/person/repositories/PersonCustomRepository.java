package com.example.person.repositories;

import com.example.person.models.Person;

import java.util.List;

public interface PersonCustomRepository{
    public List<Person> getAllStories();
    public List<Object[]> partOfPeoplesNames(String partOfTheName);
}
