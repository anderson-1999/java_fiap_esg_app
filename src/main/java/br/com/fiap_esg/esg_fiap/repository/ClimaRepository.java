package br.com.fiap_esg.esg_fiap.repository;

import br.com.fiap_esg.esg_fiap.entity.ClimaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClimaRepository extends JpaRepository<ClimaEntity, Long> {
}