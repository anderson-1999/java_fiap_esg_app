package br.com.fiap_esg.esg_fiap.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthenticationRequestDTO(
        @NotBlank(message = "O login é obrigatório!")
        String login,

        @NotBlank(message = "A senha é obrigatória!")
        @Size(min = 5, max = 20, message = "A senha dever entre 6 a 20 caracteres!")
        String senha
) {
}
