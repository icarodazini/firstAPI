package com.example.person.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Dieta", url = "https://www.tabelatacoonline.com.br")
public interface DietaServiceInterface {

    @GetMapping("/api/data")
    String getExampleData();

}
