package com.example.person.services;

import com.example.person.models.Person;

import java.util.List;

public interface PersonService {
    public List<Person> buscarParteDoNome(String parteDoNome);
}
