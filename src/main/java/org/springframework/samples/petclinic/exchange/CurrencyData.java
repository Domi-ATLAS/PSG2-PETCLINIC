package org.springframework.samples.petclinic.exchange;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrencyData {
    private Map<String, Double> data;

    public Map<String, Double> getData() {
        return data;
    }

    public void setData(Map<String, Double> data) {
        this.data = data;
    }

    public static void main(String[] args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.freecurrencyapi.com/v1/latest?apikey=0whTEceC20hXneP3rSzGmYS0Vwws8ieXvxKDRXHU";
        String json = restTemplate.getForObject(apiUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        CurrencyData currencyData = mapper.readValue(json, CurrencyData.class);
        Map<String, Double> data = currencyData.getData();
        for(String s: data.keySet()){

            System.out.println(s + ": " +data.get(s));
        }
    }
}