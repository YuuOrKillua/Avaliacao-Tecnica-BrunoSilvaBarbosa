package BrunoSilva.DesafioDigix.DTOs.responses;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class FamiliaPontoResponseDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotBlank
    private String nomeDoResponsavel;

    @NotNull
    private float rendaTotal;

    @NotNull
    private int dependentes;

    private int pontos;

    //No args contructor
    public FamiliaPontoResponseDTO(){

    }
    //All args contructor
    public FamiliaPontoResponseDTO(long id, String nomeDoResponsavel, float rendaTotal, int dependentes, int pontos) {
        this.id = id;
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.rendaTotal = rendaTotal;
        this.dependentes = dependentes;
        this.pontos = pontos;
    }
}
