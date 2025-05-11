package br.com.fiap_esg.esg_fiap.reponse;

import br.com.fiap_esg.esg_fiap.entity.CidadeEntity;
import br.com.fiap_esg.esg_fiap.entity.ClimaEntity;

public record CidadeResponseDTO(
        Long id,
        String nomeCidade,
        String barrio,
        String estado,
        String cep
) {

    public CidadeResponseDTO(CidadeEntity novaCidade){
        this(
                novaCidade.getId(),
                novaCidade.getNomeCidade(),
                novaCidade.getBarrio(),
                novaCidade.getEstado(),
                novaCidade.getCep()
        );
    }

}
