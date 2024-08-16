package com.example.person.repositories;

import com.example.person.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// ↓ E usada para definir contratos, promover a reutilização de código e criar sistemas flexíveis e desacoplados.
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName (String name);
}
