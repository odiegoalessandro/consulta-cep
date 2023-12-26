package com.example.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CepValidator {
    public static boolean isValid(String cep){
        Pattern cepPattern = Pattern.compile("\\d{5}-\\d{3}");
        Matcher cepMatcher = cepPattern.matcher(cep);

        return cepMatcher.matches();
    }
}
