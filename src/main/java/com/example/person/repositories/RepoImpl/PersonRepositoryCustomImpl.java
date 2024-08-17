package com.example.person.repositories.RepoImpl;

import com.example.person.models.Person;
import com.example.person.repositories.PersonCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

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

    public List<Person> partOfPeoplesNames(String partOfTheName){
        try {

            String query = "SELECT * FROM person where name ilike '%"+partOfTheName+"%'";
            List<Person> personList = entityManager.createNativeQuery(query,Person.class).getResultList();

            return personList;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
