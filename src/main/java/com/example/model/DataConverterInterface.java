package com.example.model;

public interface DataConverterInterface {
    <T> T getData(String json, Class<T> convertedClass);
}
