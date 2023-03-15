package org.springframework.samples.petclinic.cause;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.donation.Donation;
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

    @NotBlank
    private String nonProfitOrganization;

    @NotNull
    private Boolean isClosed;

   @OneToMany
   @NotNull 
   private List<Donation> donations;

   public Cause(){
    this.isClosed = false;
    this.donations = new ArrayList<Donation>();
   }

   public Double getAchievedBudget(){
    Double res = 0.0;
    for(Donation e:this.getDonations()){
        res += e.getCantidad();
    }
    return res;
   }
    
}
