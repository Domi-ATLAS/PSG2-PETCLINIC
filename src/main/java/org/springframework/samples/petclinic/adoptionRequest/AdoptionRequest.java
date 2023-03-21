package org.springframework.samples.petclinic.adoptionRequest;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import org.springframework.samples.petclinic.adptionResponse.AdoptionResponse;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AdoptionRequest extends BaseEntity{

    @ManyToOne
    private Owner author;

    @NotNull
    private String message;

    @OneToMany
    private List<AdoptionResponse> responses;

    @OneToOne(optional = true)
    private AdoptionResponse selectedResponse;

    @ManyToOne(optional = false)
    private Pet pet;

    private Boolean avalible;
    
}
