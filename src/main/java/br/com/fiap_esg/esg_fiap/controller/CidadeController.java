package br.com.fiap_esg.esg_fiap.controller;

import br.com.fiap_esg.esg_fiap.reponse.CidadeResponseDTO;
import br.com.fiap_esg.esg_fiap.request.CidadeRequestDTO;
import br.com.fiap_esg.esg_fiap.service.CidadeService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidade", produces = {"application/json"})
//@Tag(name = "Cidades")
@RequiredArgsConstructor
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CidadeResponseDTO> gravarDadosCidade(@RequestBody CidadeRequestDTO cidadeRequestDTO){
        return ResponseEntity.ok(cidadeService.gravarCidade(cidadeRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeResponseDTO> buscaCidadePorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cidadeService.buscaDadosCidade(id));
    }

    @GetMapping
    public ResponseEntity<List<CidadeResponseDTO>> buscaTodasCidades() {
        return ResponseEntity.ok(cidadeService.buscarTodasCidades());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletaDadosCidade(@PathVariable ("id") Long id) {

        cidadeService.deletaDadosCidade(id);
        return ResponseEntity.accepted().build();

    }
}
