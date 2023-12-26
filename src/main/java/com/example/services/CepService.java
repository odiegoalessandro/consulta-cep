package com.example.services;

import com.example.model.CepEntity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CepService {
    private static final String fistApi = "https://viacep.com.br/ws/";
    private static final String secondApi = "https://cdn.apicep.com/file/apicep/";
    private static DataService dataService = new DataService();

    public static CepEntity getCepData(String cep){
        CompletableFuture<String> futureFirstApi = createFuture(fistApi + cep + "/json");
        CompletableFuture<String> futureSecondApi = createFuture(secondApi + cep + ".json");
        CompletableFuture<Object> anyApi = CompletableFuture.anyOf(futureFirstApi, futureSecondApi);

        try {
            return dataService.getData(anyApi.get().toString(), CepEntity.class);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static CompletableFuture<String> createFuture(String url){
        return CompletableFuture.supplyAsync(() -> ApiService.getContent(url)).exceptionally(e -> e.getMessage());
    }
}
