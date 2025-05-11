package br.com.fiap_esg.esg_fiap.controller;

import br.com.fiap_esg.esg_fiap.entity.ClimaEntity;
import br.com.fiap_esg.esg_fiap.reponse.ClimaResponseDTO;
import br.com.fiap_esg.esg_fiap.request.ClimaRequestDTO;
import br.com.fiap_esg.esg_fiap.service.ClimaService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clima", produces = {"application/json"})
//@Tag(name = "Clima")
@RequiredArgsConstructor
public class ClimaController {

    @Autowired
    private ClimaService climaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClimaResponseDTO> gravarDadosClima(@RequestBody ClimaRequestDTO climaRequestDTO){
        return ResponseEntity.ok(climaService.gravarClima(climaRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClimaResponseDTO> buscaClimaPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(climaService.buscaDadosClima(id));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ClimaResponseDTO>> buscaTodosClimas() {
        return ResponseEntity.ok(climaService.buscarTodosClimas());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletaDadosClima(@PathVariable("id") Long id) {
        climaService.deletaDadosClima(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ClimaResponseDTO atualizar(@RequestBody ClimaEntity climaEntity){
        return climaService.atualizar(climaEntity);
    }
}

