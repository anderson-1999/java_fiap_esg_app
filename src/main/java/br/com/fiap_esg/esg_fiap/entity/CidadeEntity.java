package br.com.fiap_esg.esg_fiap.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "T_CIDADE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CidadeEntity implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CIDADE"
    )
    @SequenceGenerator(
            name = "SEQ_CIDADE",
            sequenceName = "SEQ_CIDADE",
            allocationSize = 1
    )
    @Column(name = "idCidade")
    private Long id;

    private String nomeCidade;
    private String barrio;
    private String estado;
    private String cep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}



