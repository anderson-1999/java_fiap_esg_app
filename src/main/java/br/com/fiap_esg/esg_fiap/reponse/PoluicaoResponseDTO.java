package br.com.fiap_esg.esg_fiap.reponse;

import br.com.fiap_esg.esg_fiap.entity.PoluicaoEntity;

public record PoluicaoResponseDTO(
        Long id,
        long idCidade,
        double co2
) {

    public PoluicaoResponseDTO(PoluicaoEntity novaPoluicao){
        this(
                novaPoluicao.getId(),
                novaPoluicao.getIdCidade(),
                novaPoluicao.getCo2()
        );
    }

}
