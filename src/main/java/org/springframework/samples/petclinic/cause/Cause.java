package org.springframework.samples.petclinic.cause;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cause extends NamedEntity{

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    @Min(1)
    private Double budgetTarget;

    @NotNull
    private Double achievedBudget;

    @NotBlank
    private String nonProfitOrganization;

    @NotNull
    private Boolean isClosed;

   // SE IMPLEMENTARÁ CUANDO TENGAMOS EL TIPO DONATION DEFINIDO 
   // @OneToMany
   // @NotNull 
   // private List<Donation> donations;

   public Cause(){
    this.isClosed = false;
    this.achievedBudget = 0.0;
    // this.donations = new ArrayList<>();
   }

    
}
