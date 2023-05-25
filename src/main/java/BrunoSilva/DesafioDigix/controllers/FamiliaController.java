package BrunoSilva.DesafioDigix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BrunoSilva.DesafioDigix.DTOs.requests.FamiliaRequestDTO;
import BrunoSilva.DesafioDigix.DTOs.responses.FamiliaPontoResponseDTO;
import BrunoSilva.DesafioDigix.models.Familia;
import BrunoSilva.DesafioDigix.services.FamiliaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = { "/familia" }, produces = { "application/json" })
public class FamiliaController {
    @Autowired
    FamiliaService familiaService;

    @Operation(summary = "Retorna uma familia cadastrada no service")
    @ApiResponse(responseCode = "201")
    @PostMapping(consumes = { "application/json" })
    public ResponseEntity<FamiliaPontoResponseDTO> retornarFamiliaCriada(@RequestBody FamiliaRequestDTO novaFamilia){
        return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.retornarESalvarFamilia(novaFamilia));
    }

    @Operation(summary = "Chamar uma lista de de familias ordenadas por ponto decrescente")
    @ApiResponse(responseCode = "200", description = "Lista de tipos registrados")
    @GetMapping
    public ResponseEntity<List<Familia>> buscarFamiliasPorOrdemDePontos() {
        List<Familia> familias = familiaService.buscarPorOrdemDePontos();
        return ResponseEntity.ok(familias);
    }
}
