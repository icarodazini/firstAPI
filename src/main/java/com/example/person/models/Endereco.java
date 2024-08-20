package com.example.person.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "estado")
        private String estado;

        @Column(name = "cidade")
        private String cidade;

        @Column(name = "bairro")
        private String bairro;

        @Column(name = "rua")
        private String rua;

        @ManyToOne
        @JoinColumn(name = "person_id", nullable = false) // Define a chave estrangeira person_id na tabela endereco
        @JsonIgnore
        private Person person;

        // Construtores, Getters e Setters

        public Endereco() {}

        public Endereco(Long id, String estado, String cidade, String bairro, String rua, Person person) {
                this.id = id;
                this.estado = estado;
                this.cidade = cidade;
                this.bairro = bairro;
                this.rua = rua;
                this.person = person;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }

        public String getCidade() {
                return cidade;
        }

        public void setCidade(String cidade) {
                this.cidade = cidade;
        }

        public String getBairro() {
                return bairro;
        }

        public void setBairro(String bairro) {
                this.bairro = bairro;
        }

        public String getRua() {
                return rua;
        }

        public void setRua(String rua) {
                this.rua = rua;
        }

        public Person getPerson() {
                return person;
        }

        public void setPerson(Person person) {
                this.person = person;
        }
}
