package org.springframework.samples.petclinic.exchange;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

import static java.util.Map.entry; 

@Getter
@Setter
public class ExchangeCurrency {

    //Properties
    private Double value;
    private String currency;

    private Map<String, Double> data;

    public Map<String, Double> getData() {
        return data;
    }

    public void setData(Map<String, Double> data) {
        this.data = data;
    }

    //Reference currency values respect from USD
    //We are using an API to get the updated values

    public static Map<String,Double> currencyMap(){
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.freecurrencyapi.com/v1/latest?apikey=0whTEceC20hXneP3rSzGmYS0Vwws8ieXvxKDRXHU";
        String json = restTemplate.getForObject(apiUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Double> data = null;
        try{
            CurrencyData currencyData = mapper.readValue(json, CurrencyData.class);
            data = currencyData.getData();

        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    //Reference currency values respect from USD
    //The values are volatile, so we could use an API to resolve the current values in the market
    private final Map<Currency, Double> referenceValues = Map.ofEntries(
        entry(Currency.USD, 1.0),
        entry(Currency.EUR, 0.91),
        entry(Currency.AUD, 1.51),
        entry(Currency.BTC, 0.000035)
    );

    //Constructors
    public ExchangeCurrency(){
        this.value = referenceValues.get("USD");
        this.currency = "USD";
    }

    public ExchangeCurrency(String currency, Double value){
        this.value = value;
        this.currency = currency;
    }

    //This method converts from the current currency to another 
    //Takes the currency to convert to as argument
    public ExchangeCurrency convertTo(String conversionType){

        Double newValue = this.value/currencyMap().get(this.currency)*currencyMap().get(conversionType);

        return new ExchangeCurrency(conversionType, newValue);
    }


    
    
}
