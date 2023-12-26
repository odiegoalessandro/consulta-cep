package com.example;

import com.example.services.CepService;
import com.example.validator.CepValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite um cep: ");

            String cep = scan.nextLine().trim();

            if(CepValidator.isValid(cep)) {
                System.out.println(CepService.getCepData(cep));
                continue;
            } else {
                System.out.println("Cep invalido tente novamente");
                continue;
           }
        }
    }
}