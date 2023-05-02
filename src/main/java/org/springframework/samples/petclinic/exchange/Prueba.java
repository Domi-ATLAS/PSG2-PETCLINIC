package org.springframework.samples.petclinic.exchange;

public class Prueba {

    public static void main(String[] args) {
        
        ExchangeCurrency  ec = new ExchangeCurrency(Currency.BTC, 1.3);

        System.out.println("Tengo " + ec.getValue() +" "+ ec.getCurrency().toString()+",");

        ec = ec.convertTo(Currency.EUR);

        System.out.println("que equivale a "+ ec.getValue() + ec.getCurrency().toString()+ ".");


    }
    
}
