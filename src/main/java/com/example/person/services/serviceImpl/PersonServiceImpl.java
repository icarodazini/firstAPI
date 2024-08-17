package com.example.person.services.serviceImpl;

import com.example.person.models.Person;
import com.example.person.repositories.PersonCustomRepository;
import com.example.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonCustomRepository personCustomRepository;
    @Override
    public List<Person> buscarParteDoNome(String parteDoNome) {

        List<Person> listaDePessoasRetornadas = personCustomRepository.partOfPeoplesNames(parteDoNome);

        return listaDePessoasRetornadas;
    }
}
