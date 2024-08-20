package com.example.person.repositories.RepoImpl;

import com.example.person.models.Person;
import com.example.person.repositories.PersonCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryCustomImpl implements PersonCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getAllStories() {
        try {

            List<Person> storyList = entityManager.createNativeQuery("SELECT * FROM person",Person.class).getResultList();

            return storyList;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public List<Object[]> partOfPeoplesNames(String name){
        try {
            String query3 = "SELECT p.id AS person_id, p.name, p.email, e.id, e.estado, e.cidade, e.bairro, e.rua FROM person p INNER JOIN endereco e ON e.person_id = p.id WHERE p.name ILIKE :name";

            List<Object[]> results = entityManager.createNativeQuery(query3)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();

            return results;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
