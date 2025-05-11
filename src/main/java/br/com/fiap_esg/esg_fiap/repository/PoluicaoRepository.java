package br.com.fiap_esg.esg_fiap.repository;

import br.com.fiap_esg.esg_fiap.entity.PoluicaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoluicaoRepository extends JpaRepository<PoluicaoEntity, Long> {
}
