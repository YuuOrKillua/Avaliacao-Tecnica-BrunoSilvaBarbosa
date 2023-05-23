package BrunoSilva.DesafioDigix.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.ToString;

@ToString
@Table(name = "familias")
@Entity
public class Familia {
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
    public Familia(){

    }
    //All args contructor
    public Familia(String nomeDoResponsavel, float rendaTotal, int dependentes, int pontos) {
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.rendaTotal = rendaTotal;
        this.dependentes = dependentes;
        this.pontos = pontos;
    }
    //constructor sem pontos
    public Familia(String nomeDoResponsavel, float rendaTotal, int dependentes) {
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.rendaTotal = rendaTotal;
        this.dependentes = dependentes;
    }
    //contructor para os pontos
    public Familia(int pontos){
        this.pontos = pontos;
    }
    //Setters (não vou passar no lombok @Setter, porque é errado settar id).
    public void setNomeDoResponsavel(String nomeDoResponsavel) {
        this.nomeDoResponsavel = nomeDoResponsavel;
    }
    public void setRendaTotal(int rendaTotal) {
        this.rendaTotal = rendaTotal;
    }
    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }
    public void setPontos(int ponto) {
        this.pontos = pontos;
    }
    //Getters
    public long getId() {
        return id;
    }
    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }
    public float getRendaTotal() {
        return rendaTotal;
    }
    public int getDependentes() {
        return dependentes;
    }
    public int getPontos() {
        return pontos;
    }
    
}
