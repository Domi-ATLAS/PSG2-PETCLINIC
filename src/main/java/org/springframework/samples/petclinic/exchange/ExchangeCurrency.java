package org.springframework.samples.petclinic.exchange;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeCurrency {

    //Properties
    private Double value;
    private String currency;

    //Reference currency values respect from USD
    //We are using an API to get the updated values

    public static Map<String,Double> currencyMap(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.freecurrencyapi.com/v1/latest?apikey=0whTEceC20hXneP3rSzGmYS0Vwws8ieXvxKDRXHU";
        String jsonString = restTemplate.getForObject(url, String.class);
        String nuevaString = jsonString.replace("{\"data\":", "");
        String json = nuevaString.replace("}}", "}");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Double> map = null;
        try {

            // convert JSON string to Map
            map = mapper.readValue(json, Map.class);
            map.put("USD", 1.0);

			// it works
            //Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    //Reference currency values respect from USD
    //The values are volatile, so we could use an API to resolve the current values in the market
    /*private final Map<Currency, Double> referenceValues = Map.ofEntries(
        entry(Currency.USD, 1.0),
        entry(Currency.EUR, 0.91),
        entry(Currency.AUD, 1.51),
        entry(Currency.BTC, 0.000035)
    );*/

    //Constructors
    public ExchangeCurrency(){
        this.value = currencyMap().get("USD");
        this.currency = "USD";
    }

    public ExchangeCurrency(String currency, Double value){
        this.value = value;
        this.currency = currency;
    }

    //This method converts from the current currency to another 
    //Takes the currency to convert to as argument
    public ExchangeCurrency convertTo(String conversionType){

        Double currentReference = currencyMap().get(this.currency) ;

        Double conversionReference = currencyMap().get(conversionType) ;

        Double newValue = Double.valueOf(this.value/currentReference*conversionReference);

        return new ExchangeCurrency(conversionType, newValue);
    }


    
    
}