package BrunoSilva.DesafioDigix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BrunoSilva.DesafioDigix.DTOs.requests.FamiliaRequestDTO;
import BrunoSilva.DesafioDigix.DTOs.responses.FamiliaPontoResponseDTO;
import BrunoSilva.DesafioDigix.models.Familia;
import BrunoSilva.DesafioDigix.repositories.FamiliaRepository;

@Service
public class FamiliaService {
    @Autowired
    FamiliaRepository familiaRepository;

    //Recebo uma familia postada e passo por um teste para fazer o ponto comforme informações da familia.
    public int fazerPontosFamilia(FamiliaRequestDTO novaFamilia){
        //Dados que serão recebidos quando uma familia for criada.
        float rendaTotalFamilia = novaFamilia.getRendaTotal();
        int dependentesFamilia = novaFamilia.getDependentes();
        //Pontos começam valendo 0.
        int pontoInicialDependentes = 0;
        int pontoInicialRenda = 0;
        int pontosTotais = 0;
        //Essa lista define o tamanho de todas listas usadas.
        int listaTamanho[] = {0, 0};
        //Lista de comparação.
        int listaRenda[] = {900, 1500};
        int listaDependentes[] = {2, 3};
        //Pontos atriubuidos a lista de compração.
        int listaDePontosRenda[] = {5, 3};
        int listaDePontosDependentes[] = {2, 3};
        for(int i = 0; i < listaTamanho.length; i++){
            if(rendaTotalFamilia <= listaRenda[0]){
                pontoInicialRenda = listaDePontosRenda[0];
            }else if (rendaTotalFamilia <= listaRenda[1]) {
                pontoInicialRenda = listaDePontosRenda[1];
            } 
            if(dependentesFamilia <= listaDependentes[0] && dependentesFamilia != 0 ){
                pontoInicialDependentes = listaDePontosDependentes[0];
            }else if (dependentesFamilia >= listaDependentes[1]) {
                pontoInicialDependentes = listaDePontosDependentes[1];
            } 
        }
        pontosTotais = pontoInicialDependentes + pontoInicialRenda;
        System.out.println(pontosTotais);
        return pontosTotais;
    }

    //Aqui coloco o ponto criado no outro método.
    public Familia criarFamiliaComPonto( FamiliaRequestDTO familiaCriada) {
        int pontosTotais = fazerPontosFamilia(familiaCriada);
        //Lógica para colocar ponto na familia já criada.
        Familia familiaQueGanharaPontos = new Familia(familiaCriada.getNomeDoResponsavel(), familiaCriada.getRendaTotal(),
        familiaCriada.getDependentes(), pontosTotais);
        return new Familia(familiaQueGanharaPontos.getNomeDoResponsavel(),
                familiaQueGanharaPontos.getRendaTotal(), familiaQueGanharaPontos.getDependentes(),
                familiaQueGanharaPontos.getPontos());
    }
    
    public FamiliaPontoResponseDTO retornarESalvarFamilia( FamiliaRequestDTO novaFamilia){
        Familia familiaQueGanharaPontos = criarFamiliaComPonto(novaFamilia);
        familiaRepository.save(familiaQueGanharaPontos);
        return new FamiliaPontoResponseDTO(familiaQueGanharaPontos.getId(),
                familiaQueGanharaPontos.getNomeDoResponsavel(),
                familiaQueGanharaPontos.getRendaTotal(), familiaQueGanharaPontos.getDependentes(),
                familiaQueGanharaPontos.getPontos());
    }

    public List<Familia> buscarPorOrdemDePontos() {
        List<Familia> resultado = familiaRepository.findByOrderByPontosDec();
        return resultado;
    }
}
