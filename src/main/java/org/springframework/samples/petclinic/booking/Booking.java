package org.springframework.samples.petclinic.booking;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Booking extends BaseEntity{
    
    @OneToOne
    public Pet pet;

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    public LocalDate startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    public LocalDate finishDate;
}
