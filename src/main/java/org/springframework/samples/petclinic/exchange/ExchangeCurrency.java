package org.springframework.samples.petclinic.exchange;

import java.util.Map;


import lombok.Getter;
import lombok.Setter;

import static java.util.Map.entry; 

@Getter
@Setter
public class ExchangeCurrency {

    //Properties
    private Double value;
    private Currency currency;

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
        this.value = referenceValues.get(Currency.USD);
        this.currency = Currency.USD;
    }

    public ExchangeCurrency(Currency currency, Double value){
        this.value = value;
        this.currency = currency;
    }

    //This method converts from the current currency to another 
    //Takes the currency to convert as argument
    public ExchangeCurrency convertTo(Currency conversionType){

        Double newValue = this.value/referenceValues.get(this.currency)*referenceValues.get(conversionType);

        return new ExchangeCurrency(conversionType, newValue);
    }


    
    
}
