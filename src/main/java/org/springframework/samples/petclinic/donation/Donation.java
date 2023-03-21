package org.springframework.samples.petclinic.donation;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Donation extends BaseEntity{

    @Min(1)
    @NotNull
    private Double amount;

    @NotBlank
    private String donorName;

    @NotNull
    private String message;

    @NotNull
    private LocalDate date;

    public Donation(){
        this.date = LocalDate.now();
    }
    
}
