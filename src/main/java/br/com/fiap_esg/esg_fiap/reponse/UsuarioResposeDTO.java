package br.com.fiap_esg.esg_fiap.reponse;

import br.com.fiap_esg.esg_fiap.entity.UsuarioEntity;
import br.com.fiap_esg.esg_fiap.utils.UserRole;

public record UsuarioResposeDTO(
        Long id,
        String login,
        UserRole role
) {

    public UsuarioResposeDTO(UsuarioEntity novoUsuario){
        this(
                novoUsuario.getId(),
                novoUsuario.getUsername(),
                novoUsuario.getRole()
        );
    }

}
