package br.com.fiap_esg.esg_fiap.controller;

import br.com.fiap_esg.esg_fiap.reponse.PoluicaoResponseDTO;
import br.com.fiap_esg.esg_fiap.request.PoluicaoRequestDTO;
import br.com.fiap_esg.esg_fiap.service.PoluicaoService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/poluicao", produces = {"application/json"})
//@Tag(name = "Poluição")
@RequiredArgsConstructor
@Data
public class PoluicaoController {

    @Autowired
    private PoluicaoService poluicaoService;

    @PostMapping
    public ResponseEntity<PoluicaoResponseDTO> gravarDadosPoluicao(@RequestBody PoluicaoRequestDTO poluicaoRequestDTO){
        return ResponseEntity.ok(poluicaoService.gravarPoluicao(poluicaoRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoluicaoResponseDTO> buscaPoluicaoPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(poluicaoService.buscaDadosPoluicao(id));
    }

    @GetMapping
    public ResponseEntity<List<PoluicaoResponseDTO>> buscaTodasPoluicoes() {
        return ResponseEntity.ok(poluicaoService.buscarTodasPoluicoes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaDadosPoluicao(@PathVariable("id") Long id) {
        poluicaoService.deletaDadosPoluicao(id);
        return ResponseEntity.accepted().build();
    }
}

