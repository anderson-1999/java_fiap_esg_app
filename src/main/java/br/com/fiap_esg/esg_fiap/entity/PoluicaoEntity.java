package br.com.fiap_esg.esg_fiap.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "T_POLUICAO")
public class PoluicaoEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_POLUICAO"
    )
    @SequenceGenerator(
            name = "SEQ_POLUICAO",
            sequenceName = "SEQ_POLUICAO",
            allocationSize = 1
    )
    @Column(name = "idPoluicao")
    private Long id;
    private long idCidade;
    private double co2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(long idCidade) {
        this.idCidade = idCidade;
    }

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }
}



