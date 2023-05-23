package BrunoSilva.DesafioDigix.DTOs.responses;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class FamiliaResponseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank
    private String nomeDoResponsavel;

    @NotNull
    private float rendaTotal;

    @NotNull
    private int dependentes;

    //No args contructor
    public FamiliaResponseDTO(){

    }
    //All args contructor
    public FamiliaResponseDTO(long id, String nomeDoResponsavel, float rendaTotal, int dependentes) {
        this.id = id;
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.rendaTotal = rendaTotal;
        this.dependentes = dependentes;
    }
}
