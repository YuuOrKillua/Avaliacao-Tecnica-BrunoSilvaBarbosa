package BrunoSilva.DesafioDigix.DTOs.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class FamiliaPontoRequestDTO {
    @NotBlank
    private String nomeDoResponsavel;

    @NotNull
    private float rendaTotal;

    @NotNull
    private int dependentes;

    private int pontos;

    //No args contructor
    public FamiliaPontoRequestDTO(){

    }
    //All args contructor
    public FamiliaPontoRequestDTO(String nomeDoResponsavel, float rendaTotal, int dependentes, int pontos) {
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.rendaTotal = rendaTotal;
        this.dependentes = dependentes;
        this.pontos = pontos;
    }
    //Ponto constructor
    public FamiliaPontoRequestDTO(int pontos){
        this.pontos = pontos;
    }
}
