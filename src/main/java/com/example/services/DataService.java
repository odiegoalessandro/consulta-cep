package com.example.services;

import com.example.model.DataConverterInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataService implements DataConverterInterface {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> convertedClass) {

        try {
            return mapper.readValue(json, convertedClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter dados " + e);
        }
    }
}
