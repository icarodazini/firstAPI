package com.example.person.services;

import com.example.person.models.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    public List<Person> buscarParteDoNome(String parteDoNome);
}
