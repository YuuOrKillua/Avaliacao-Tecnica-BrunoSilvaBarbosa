package BrunoSilva.DesafioDigix.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import BrunoSilva.DesafioDigix.DTOs.requests.FamiliaRequestDTO;

import BrunoSilva.DesafioDigix.models.Familia;

@SpringBootTest
@ComponentScan(basePackages = "BrunoSilva.DesafioDigix.services.FamiliaService")
public class FamiliaServiceTest {
    @Autowired
    private FamiliaService familiaService;

    @Test
    public void testar_ponto_na_familia_sem_dependentes_e_com_mais_de_1500_de_renda() {
        FamiliaRequestDTO familiaCriada = new FamiliaRequestDTO("Roberto", 1501, 0);
        familiaService.criarFamiliaComPonto(familiaCriada);
        Familia familiaComPontos = new Familia(familiaCriada.getNomeDoResponsavel(), familiaCriada.getRendaTotal(),
                familiaCriada.getDependentes());
        assertEquals(familiaComPontos.getPontos(), 0);
    }

    @Test
    public void testar_ponto_na_familia_sem_dependentes_e_com_a_renda_menor_igual_a_900() {
        FamiliaRequestDTO familiaCriada = new FamiliaRequestDTO("Roberto", 800, 0);
        familiaService.criarFamiliaComPonto(familiaCriada);
        Familia familiaComPontos = new Familia(familiaCriada.getNomeDoResponsavel(), familiaCriada.getRendaTotal(),
                familiaCriada.getDependentes());
        assertEquals(familiaComPontos.getPontos(), 0);
    }
    
    @Test
    public void testar_ponto_na_familia_sem_dependentes_e_com_a_renda_menor_igual_a_1500() {
        FamiliaRequestDTO familiaCriada = new FamiliaRequestDTO("Roberto", 1499, 0);
        familiaService.criarFamiliaComPonto(familiaCriada);
        Familia familiaComPontos = new Familia(familiaCriada.getNomeDoResponsavel(), familiaCriada.getRendaTotal(),
                familiaCriada.getDependentes());
        assertEquals(familiaComPontos.getPontos(), 3);
    }

    public FamiliaServiceTest() {

    }
}