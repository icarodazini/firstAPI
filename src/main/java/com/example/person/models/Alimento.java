package com.example.person.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties (ignoreUnknown = true)
public class Alimento {

    @JsonProperty("id")
    private int id;

    @JsonProperty("grupo")
    private String grupo;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("energia_kcal")
    private int kcal;

    @JsonProperty("proteina_g")
    private String proteina;

    @JsonProperty("carboidrato_g")
    private String carboidrato;

    @JsonProperty("lipideos_g")
    private String gordura;

    @JsonProperty("slug")
    private String slug;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getProteina() {
        return proteina;
    }

    public void setProteina(String proteina) {
        this.proteina = proteina;
    }

    public String getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(String carboidrato) {
        this.carboidrato = carboidrato;
    }

    public String getGordura() {
        return gordura;
    }

    public void setGordura(String gordura) {
        this.gordura = gordura;
    }
}