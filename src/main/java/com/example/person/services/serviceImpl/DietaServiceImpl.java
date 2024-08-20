package com.example.person.services.serviceImpl;

import com.example.person.services.DietaServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class DietaServiceImpl {

    private final DietaServiceInterface dietaService;

    public DietaServiceImpl(DietaServiceInterface exampleClient) {
        this.dietaService = exampleClient;
    }

    public String fetchData() {
        return dietaService.getExampleData();
    }
}

