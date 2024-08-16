package com.example.person.controllers;

import com.example.person.models.Person;
import com.example.person.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Person>> findAll(){
        List<Person> personList = personRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(personList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Person> findOneById(@PathVariable(value = "id") Long id){
        Optional<Person> personById = personRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(personById.get());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Person> findOneByName(@PathVariable(value = "name")String name){
        Optional<Person> personByName = personRepository.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(personByName.get());
    }

    @PostMapping("/criar")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person result = personRepository.save(person);
        return  ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long id, @RequestBody Person person){
        if (!personRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        // ↓ Define o Id da pessoa que deseja modificar na URL. Isso garante que a pessoa tenha um Id correto antes de salvar
        person.setId(id);
        // ↓ Salva a pessoa no banco de dados, ai se o Id existir, ele atualiza
        person = personRepository.save(person);
        // ↓ Retorna uma resposta HTTP 200 ok, junto com a pessoa já atualizada
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario a ser deletado nao foi encontrado no banco de dados");
        }
        personRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }
}
