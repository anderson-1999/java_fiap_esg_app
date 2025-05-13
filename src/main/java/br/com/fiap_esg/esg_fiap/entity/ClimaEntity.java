package br.com.fiap_esg.esg_fiap.entity;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode
@Table(name = "T_CLIMA")
public class ClimaEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CLIMA"
    )
    @SequenceGenerator(
            name = "SEQ_CLIMA",
            sequenceName = "SEQ_CLIMA",
            allocationSize = 1
    )
    @Column(name = "id_clima")
    private Long id;

    @Column(name = "id_cidade")
    private long idCidade;
    private double temperatura;
    private double humidade;

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

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getHumidade() {
        return humidade;
    }

    public void setHumidade(double humidade) {
        this.humidade = humidade;
    }
}


