package com.example.person.controllers;

import com.example.person.services.DietaServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dieta")
public class DietaController {

    private final DietaServiceInterface dietaServiceInterface;

    public DietaController(DietaServiceInterface dietaServiceInterface) {
        this.dietaServiceInterface = dietaServiceInterface;
    }

    @GetMapping("/dados")
    public String chamarApiDeDieta() {
        return dietaServiceInterface.getExampleData();
    }
}