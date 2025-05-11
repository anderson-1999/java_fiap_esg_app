package br.com.fiap_esg.esg_fiap.request;

public record CidadeRequestDTO(
        String nomeCidade,
        String barrio,
        String estado,
        String cep
) {
}
