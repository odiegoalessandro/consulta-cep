package com.example.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CepEntity(
        @JsonAlias({"cep", "code"}) String cep,
        @JsonAlias({"logradouro", "address"}) String logradouro,
        @JsonAlias({"uf", "state"}) String uf,
        @JsonAlias({"bairro", "district"}) String bairro,
        @JsonAlias({"localidade", "city"}) String localidade) {
}
