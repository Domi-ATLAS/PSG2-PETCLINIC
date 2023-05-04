package org.springframework.samples.petclinic.exchange;

public class Prueba {

    public static void main(String[] args) {

        for(String s: ExchangeCurrency.currencyMap().keySet()){
            //System.out.println(s + ": "+ ExchangeCurrency.currencyMap().get(s));
        }

    }
    
}
