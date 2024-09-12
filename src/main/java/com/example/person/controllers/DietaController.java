package com.example.person.controllers;

import com.example.person.models.Alimento;
import com.example.person.services.DietaServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/dieta", produces = "application/json")
public class DietaController {

    private final DietaServiceInterface dietaServiceInterface;

    public DietaController(DietaServiceInterface dietaServiceInterface) {
        this.dietaServiceInterface = dietaServiceInterface;
    }

    @GetMapping("/dados")
    public ResponseEntity<List<Alimento>> chamarApiDeDieta() {

        String dadosDeTodasDietas = dietaServiceInterface.getExampleData();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Alimento[] alimentosArray = objectMapper.readValue(dadosDeTodasDietas, Alimento[].class);
            List<Alimento> alimentos = Arrays.asList(alimentosArray);

            for (Alimento alimento : alimentos) {
                System.out.println("Descrição: " + alimento.getDescricao() + ", Kcal: " + alimento.getKcal());
            }
            return ResponseEntity.status(HttpStatus.OK).body(alimentos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/dados/{parteDoNome}")
    public ResponseEntity<List<Alimento>> chamarApiDietaParte(@PathVariable(value = "parteDoNome")String parteDoNome) {

        String dadosDeTodasDietas = dietaServiceInterface.getExampleData();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Alimento[] alimentosArray = objectMapper.readValue(dadosDeTodasDietas, Alimento[].class);

            List<Alimento> alimentos = Arrays.stream(alimentosArray)
                    .filter(alimento -> alimento.getDescricao().toLowerCase().contains(parteDoNome))
                    .toList();

            return ResponseEntity.status(HttpStatus.OK).body(alimentos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}