package org.springframework.samples.petclinic.donation;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Donation extends BaseEntity{

    @Min(1)
    @NotNull
    private Double amount;

    @ManyToOne(optional = true)
    private Owner donor;

    @NotNull
    private String message;

    @NotNull
    private LocalDate date;

    public Donation(){
        this.date = LocalDate.now();
    }
    
}
