package br.com.fiap_esg.esg_fiap.request;

import br.com.fiap_esg.esg_fiap.entity.CidadeEntity;

public record PoluicaoRequestDTO(
        long idCidade,
        double co2
) {
}
