package br.com.fiap_esg.esg_fiap.request;

import br.com.fiap_esg.esg_fiap.utils.UserRole;

public record RegisterRequestDTO(
        String login,
        String senha,
        UserRole role
) {
}
