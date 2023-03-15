package org.springframework.samples.petclinic.adptionResponse;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class AdoptionApplication extends BaseEntity{

    //(adoption applications will have a description of how the applicant will take care of the pet). 
    //If the original owner approves the application, the pet will be transferred to the applicant and he/she will 
    //be the new owner of the pet.

    public String description;
    
    @ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
    
}
