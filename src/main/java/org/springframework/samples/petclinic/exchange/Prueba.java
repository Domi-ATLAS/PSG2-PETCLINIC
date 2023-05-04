package org.springframework.samples.petclinic.exchange;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Prueba {

    public static void main(String[] args) {

        /*Map<String,Double> map = ExchangeCurrency.currencyMap();
        for(String s: map.keySet()){
            System.out.println(s + ": "+ map.get(s));
        }*/

        Map<String, Double> map = ExchangeCurrency.currencyMap();

        for(String s: map.keySet()){
            System.out.println(map.get(s));
        }

    }
    
}
