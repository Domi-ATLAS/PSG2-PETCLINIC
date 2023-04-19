package org.springframework.samples.petclinic.user;

public enum PricingPlan {
    BASIC(0),
    ADVANCED(2),
    PRO(Integer.MAX_VALUE);

    public int bookings;

    PricingPlan(int bookings){
        this.bookings = bookings;
    }

    public String getName(){
        return this.name();
    }
}
