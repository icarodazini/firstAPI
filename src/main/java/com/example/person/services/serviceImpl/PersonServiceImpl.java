package com.example.person.services.serviceImpl;

import com.example.person.models.Endereco;
import com.example.person.models.Person;
import com.example.person.repositories.PersonCustomRepository;
import com.example.person.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonCustomRepository personCustomRepository;
    @Override
    public List<Person> buscarParteDoNome(String parteDoNome) {

        List<Object[]> resultados = personCustomRepository.partOfPeoplesNames(parteDoNome);


        return this.convertResultsToPersonList(resultados);
    }


    public List<Person> convertResultsToPersonList(List<Object[]> results) {
        Map<Long, Person> personMap = new HashMap<>();
        List<Person> personList = new ArrayList<>();

        for (Object[] result : results) {
            Long personId = ((Number) result[0]).longValue(); // person_id
            String personName = (String) result[1]; // person_name
            String personEmail = (String) result[2]; // person_email
            Long enderecoId = ((Number) result[3]).longValue(); // endereco_id
            String estado = (String) result[4];
            String cidade = (String) result[5];
            String bairro = (String) result[6];
            String rua = (String) result[7];

            // Cria ou recupera a pessoa do mapa
            Person person = personMap.get(personId);
            if (person == null) {
                person = new Person();
                person.setId(personId);
                person.setName(personName);
                person.setEmail(personEmail);
                person.setEnderecos(new ArrayList<>());
                personMap.put(personId, person);
                personList.add(person);
            }

            // Cria o endereço e adiciona à pessoa
            Endereco endereco = new Endereco();
            endereco.setId(enderecoId);
            endereco.setEstado(estado);
            endereco.setCidade(cidade);
            endereco.setBairro(bairro);
            endereco.setRua(rua);
            //endereco.setPerson(person); // Define a pessoa associada

            person.getEnderecos().add(endereco);
        }

        return personList;
    }
}
