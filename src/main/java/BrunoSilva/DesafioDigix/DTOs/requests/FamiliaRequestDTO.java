package BrunoSilva.DesafioDigix.DTOs.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class FamiliaRequestDTO {
    @NotBlank
    private String nomeDoResponsavel;

    @NotNull
    private float rendaTotal;

    @NotNull
    private int dependentes;

    //No args contructor
    public FamiliaRequestDTO(){

    }
    //All args contructor
    public FamiliaRequestDTO(String nomeDoResponsavel, float rendaTotal, int dependentes) {
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.rendaTotal = rendaTotal;
        this.dependentes = dependentes;
    }
}
