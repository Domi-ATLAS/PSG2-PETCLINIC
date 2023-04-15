package org.springframework.samples.petclinic.user;

public enum PricingPlan {
    BASIC,ADVANCED,PRO;
    public String getName(){
        return this.name();
    }
}
