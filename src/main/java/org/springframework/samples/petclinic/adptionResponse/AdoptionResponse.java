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
public class AdoptionResponse extends BaseEntity{

    public String description;
    
    @ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
    
}
