package br.com.fiap_esg.esg_fiap.controller;

import br.com.fiap_esg.esg_fiap.entity.UsuarioEntity;
import br.com.fiap_esg.esg_fiap.reponse.AuthResponseDTO;
import br.com.fiap_esg.esg_fiap.reponse.UsuarioResposeDTO;
import br.com.fiap_esg.esg_fiap.request.AuthenticationRequestDTO;
import br.com.fiap_esg.esg_fiap.request.RegisterRequestDTO;
import br.com.fiap_esg.esg_fiap.service.AuthorizationService;
import br.com.fiap_esg.esg_fiap.utils.security.TokenService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth", produces = {"application/json"})
//@Tag(name = "Autenticão do Usuario")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationRequestDTO authenticationRequestDTO){

        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(
                        authenticationRequestDTO.login(),
                        authenticationRequestDTO.senha());

        Authentication auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());

        return ResponseEntity.ok(new AuthResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRequestDTO registerRequestDTO){

        UsuarioResposeDTO usuarioSalvo = authorizationService.salvarUsuario(registerRequestDTO);

        return ResponseEntity.ok(usuarioSalvo);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, String> handleIntegrityViolation() {

        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Usuário já cadastrado!");

        return errorMap;
    }


}
