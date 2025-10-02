package br.com.fiap_esg.esg_fiap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste")
public class testController {

    @GetMapping
    public ResponseEntity<String> testeMensagem() {
        return ResponseEntity.ok("oi Mundo");
    }

}
