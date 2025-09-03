package br.com.fiap_esg.esg_fiap.reponse;

import br.com.fiap_esg.esg_fiap.entity.ClimaEntity;

public record ClimaResponseDTO(
        Long id,
        long idCidade,
        double temperatura,
        double humidade
) {
    public ClimaResponseDTO(ClimaEntity novoClima){
        this(
                novoClima.getId(),
                novoClima.getIdCidade(),
                novoClima.getTemperatura(),
                novoClima.getHumidade()
        );
    }
}
